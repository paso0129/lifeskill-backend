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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final ParticipationService participationService;
    private final ParticipationRepository participationRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    private User getTeacher(Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        if (user.getRole() != UserRole.TEACHER) {
            throw new BusinessException("교사 권한이 필요합니다.", HttpStatus.FORBIDDEN);
        }
        return user;
    }

    // 선생님의 학교/학년/반에 해당하는 학생 ID 목록
    private List<Long> getMyStudentIds(User teacher) {
        return userRepository.findByRoleAndSchoolAndGradeAndClassNum(
                UserRole.STUDENT, teacher.getSchool(), teacher.getGrade(), teacher.getClassNum()
        ).stream().map(User::getId).collect(Collectors.toList());
    }

    // 내 반 학생들의 참여 목록 (상태 필터링 가능)
    @GetMapping("/participations")
    public ResponseEntity<Page<Participation>> getMyClassParticipations(
            Authentication authentication,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        User teacher = getTeacher(authentication);
        List<Long> studentIds = getMyStudentIds(teacher);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());

        if (studentIds.isEmpty()) {
            return ResponseEntity.ok(Page.empty(pageable));
        }

        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(participationRepository.findByUserIdInAndStatus(studentIds, status, pageable));
        }
        return ResponseEntity.ok(participationRepository.findByUserIdIn(studentIds, pageable));
    }

    // 특정 학생의 참여 목록
    @GetMapping("/participations/student/{studentId}")
    public ResponseEntity<Page<Participation>> getParticipationsByStudent(
            Authentication authentication,
            @PathVariable Long studentId,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        User teacher = getTeacher(authentication);
        List<Long> studentIds = getMyStudentIds(teacher);

        if (!studentIds.contains(studentId)) {
            throw new BusinessException("해당 학생은 담당 학급이 아닙니다.", HttpStatus.FORBIDDEN);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(participationService.getParticipationsByUserAndStatus(studentId, status, pageable));
        }
        return ResponseEntity.ok(participationService.getMyParticipationsPaged(studentId, pageable));
    }

    // 특정 활동의 참여 목록 (내 반 학생만)
    @GetMapping("/participations/activity/{activityId}")
    public ResponseEntity<Page<Participation>> getParticipationsByActivity(
            Authentication authentication,
            @PathVariable Long activityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        getTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getParticipationsByActivityPaged(activityId, pageable));
    }

    // 내 반 대시보드 통계
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard(Authentication authentication) {
        User teacher = getTeacher(authentication);
        List<Long> studentIds = getMyStudentIds(teacher);

        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("school", teacher.getSchool());
        dashboard.put("grade", teacher.getGrade());
        dashboard.put("classNum", teacher.getClassNum());
        dashboard.put("totalStudents", studentIds.size());

        if (studentIds.isEmpty()) {
            dashboard.put("totalParticipations", 0L);
            dashboard.put("pendingCount", 0L);
            dashboard.put("approvedCount", 0L);
            dashboard.put("rejectedCount", 0L);
        } else {
            dashboard.put("totalParticipations", participationRepository.countByUserIdIn(studentIds));
            dashboard.put("pendingCount", participationRepository.countByUserIdInAndStatus(studentIds, "PENDING"));
            dashboard.put("approvedCount", participationRepository.countByUserIdInAndStatus(studentIds, "APPROVED"));
            dashboard.put("rejectedCount", participationRepository.countByUserIdInAndStatus(studentIds, "REJECTED"));
        }
        return ResponseEntity.ok(dashboard);
    }

    // 참여 승인
    @PutMapping("/participations/{id}/approve")
    public ResponseEntity<Participation> approveParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        getTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "APPROVED"));
    }

    // 참여 거절
    @PutMapping("/participations/{id}/reject")
    public ResponseEntity<Participation> rejectParticipation(
            Authentication authentication,
            @PathVariable Long id) {
        getTeacher(authentication);
        return ResponseEntity.ok(participationService.updateStatus(id, "REJECTED"));
    }

    // 내 반 학생 목록
    @GetMapping("/students")
    public ResponseEntity<Page<User>> getStudents(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        User teacher = getTeacher(authentication);
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<User> students = userRepository.findByRoleAndSchoolAndGradeAndClassNum(
                UserRole.STUDENT, teacher.getSchool(), teacher.getGrade(), teacher.getClassNum(), pageable);
        students.getContent().forEach(u -> u.setPassword(null));
        return ResponseEntity.ok(students);
    }
}
