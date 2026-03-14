package com.lifeskill.controller;

import com.lifeskill.entity.Participation;
import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import com.lifeskill.exception.BusinessException;
import com.lifeskill.repository.UserRepository;
import com.lifeskill.service.ParticipationService;
import com.lifeskill.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final ParticipationService participationService;
    private final UserService userService;
    private final UserRepository userRepository;

    private void verifyTeacher(Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        if (user.getRole() != UserRole.TEACHER) {
            throw new BusinessException("교사 권한이 필요합니다.", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/participations")
    public ResponseEntity<Page<Participation>> getAllParticipations(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        verifyTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getAllParticipationsPaged(pageable));
    }

    @GetMapping("/participations/activity/{activityId}")
    public ResponseEntity<Page<Participation>> getParticipationsByActivity(
            Authentication authentication,
            @PathVariable Long activityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        verifyTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getParticipationsByActivityPaged(activityId, pageable));
    }

    @PutMapping("/participations/{id}/approve")
    public ResponseEntity<Participation> approveParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        verifyTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "APPROVED"));
    }

    @PutMapping("/participations/{id}/reject")
    public ResponseEntity<Participation> rejectParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        verifyTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "REJECTED"));
    }

    @GetMapping("/students")
    public ResponseEntity<Page<User>> getStudents(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        verifyTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<User> students = userRepository.findByRole(UserRole.STUDENT, pageable);
        students.getContent().forEach(u -> u.setPassword(null));
        return ResponseEntity.ok(students);
    }
}
