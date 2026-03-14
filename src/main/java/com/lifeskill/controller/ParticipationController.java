package com.lifeskill.controller;

import com.lifeskill.entity.Participation;
import com.lifeskill.service.FileStorageService;
import com.lifeskill.service.ParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/participations")
@RequiredArgsConstructor
public class ParticipationController {

    private final ParticipationService participationService;
    private final FileStorageService fileStorageService;

    @PostMapping
    public ResponseEntity<Participation> createParticipation(
            Authentication authentication,
            @RequestParam("activityId") Long activityId,
            @RequestParam(value = "reviewText", required = false) String reviewText,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "exerciseCount", required = false) Integer exerciseCount,
            @RequestParam(value = "exerciseSets", required = false) Integer exerciseSets) {

        String fileUrl = fileStorageService.storeFile(file);
        String username = authentication.getName();

        Participation participation = participationService.createParticipation(
                username, activityId, fileUrl, reviewText, exerciseCount, exerciseSets);

        return ResponseEntity.ok(participation);
    }

    @GetMapping("/me")
    public ResponseEntity<Page<Participation>> getMyParticipations(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        String username = authentication.getName();
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getMyParticipationsPaged(username, pageable));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Page<Participation>> getParticipationsByActivity(
            @PathVariable Long activityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getParticipationsByActivityPaged(activityId, pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Participation>> getAllParticipations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return ResponseEntity.ok(participationService.getAllParticipationsPaged(pageable));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Participation> updateParticipationStatus(
            @PathVariable Long id,
            @RequestBody java.util.Map<String, String> request) {
        String status = request.get("status");
        return ResponseEntity.ok(participationService.updateStatus(id, status));
    }
}
