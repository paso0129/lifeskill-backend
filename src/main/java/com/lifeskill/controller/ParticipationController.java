package com.lifeskill.controller;

import com.lifeskill.entity.Participation;
import com.lifeskill.service.FileStorageService;
import com.lifeskill.service.ParticipationService;
import lombok.RequiredArgsConstructor;
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
            @RequestParam(value = "file", required = false) MultipartFile file) {

        String fileUrl = fileStorageService.storeFile(file);
        String username = authentication.getName();

        Participation participation = participationService.createParticipation(
                username, activityId, fileUrl, reviewText);

        return ResponseEntity.ok(participation);
    }

    @GetMapping("/me")
    public ResponseEntity<List<Participation>> getMyParticipations(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(participationService.getMyParticipations(username));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Participation>> getParticipationsByActivity(@PathVariable Long activityId) {
        return ResponseEntity.ok(participationService.getParticipationsByActivity(activityId));
    }
}
