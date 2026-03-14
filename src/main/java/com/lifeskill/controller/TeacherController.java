package com.lifeskill.controller;

import com.lifeskill.entity.Participation;
import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import com.lifeskill.exception.BusinessException;
import com.lifeskill.repository.ParticipationRepository;
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

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final ParticipationService participationService;
    private final ParticipationRepository participationRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    private void verifyTeacher(Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        if (user.getRole() != UserRole.TEACHER) {
            throw new BusinessException("교사 권한이 필요합니다.", HttpStatus.FORBIDDEN);
        }
    }

    // 전체 참여 목록 (상태 필터링 가능)
    @GetMapping("/participations")
    public ResponseEntity<Page<Participation>> getAllParticipations(
            Authentication authentication,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        verifyTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(participationService.getParticipationsByStatus(status, pageable));
        }
        return ResponseEntity.ok(participationService.getAllParticipationsPaged(pageable));
    }

    // 특정 학생의 참여 목록
    @GetMapping("/participations/student/{studentId}")
    public ResponseEntity<Page<Participation>> getParticipationsByStudent(
            Authentication authentication,
            @PathVariable Long studentId,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        verifyTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(participationService.getParticipationsByUserAndStatus(studentId, status, pageable));
        }
        return ResponseEntity.ok(participationService.getMyParticipationsPaged(studentId, pageable));
    }

    // 특정 활동의 참여 목록
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

    // 대시보드 통계
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard(Authentication authentication) {
        verifyTeacher(authentication);
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalStudents", userRepository.findByRole(UserRole.STUDENT).size());
        dashboard.put("totalParticipations", participationRepository.count());
        dashboard.put("pendingCount", participationRepository.countByStatus("PENDING"));
        dashboard.put("approvedCount", participationRepository.countByStatus("APPROVED"));
        dashboard.put("rejectedCount", participationRepository.countByStatus("REJECTED"));
        return ResponseEntity.ok(dashboard);
    }

    // 참여 승인
    @PutMapping("/participations/{id}/approve")
    public ResponseEntity<Participation> approveParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        verifyTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "APPROVED"));
    }

    // 참여 거절
    @PutMapping("/participations/{id}/reject")
    public ResponseEntity<Participation> rejectParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        verifyTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "REJECTED"));
    }

    // 학생 목록
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
