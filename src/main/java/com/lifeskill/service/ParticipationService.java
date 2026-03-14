package com.lifeskill.service;

import com.lifeskill.entity.Activity;
import com.lifeskill.entity.Participation;
import com.lifeskill.entity.User;
import com.lifeskill.exception.ResourceNotFoundException;
import com.lifeskill.repository.ActivityRepository;
import com.lifeskill.repository.ParticipationRepository;
import com.lifeskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    @Transactional
    public Participation createParticipation(String username, Long activityId, String fileUrl, String reviewText) {
        return createParticipation(username, activityId, fileUrl, reviewText, null, null);
    }

    @Transactional
    public Participation createParticipation(String username, Long activityId, String fileUrl, String reviewText,
                                              Integer exerciseCount, Integer exerciseSets) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자", username));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("활동", activityId));

        Participation participation = Participation.builder()
                .user(user)
                .activity(activity)
                .fileUrl(fileUrl)
                .reviewText(reviewText)
                .exerciseCount(exerciseCount)
                .exerciseSets(exerciseSets)
                .status("PENDING")
                .build();

        return participationRepository.save(participation);
    }

    @Transactional(readOnly = true)
    public List<Participation> getMyParticipations(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자", username));
        return participationRepository.findByUserIdOrderBySubmittedAtDesc(user.getId());
    }

    @Transactional(readOnly = true)
    public Page<Participation> getMyParticipationsPaged(String username, Pageable pageable) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자", username));
        return participationRepository.findByUserId(user.getId(), pageable);
    }

    @Transactional(readOnly = true)
    public Page<Participation> getMyParticipationsPaged(Long userId, Pageable pageable) {
        return participationRepository.findByUserId(userId, pageable);
    }

    @Transactional(readOnly = true)
    public List<Participation> getParticipationsByActivity(Long activityId) {
        return participationRepository.findByActivityId(activityId);
    }

    @Transactional(readOnly = true)
    public Page<Participation> getParticipationsByActivityPaged(Long activityId, Pageable pageable) {
        return participationRepository.findByActivityId(activityId, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Participation> getAllParticipationsPaged(Pageable pageable) {
        return participationRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Participation> getParticipationsByStatus(String status, Pageable pageable) {
        return participationRepository.findByStatus(status, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Participation> getParticipationsByUserAndStatus(Long userId, String status, Pageable pageable) {
        return participationRepository.findByUserIdAndStatus(userId, status, pageable);
    }

    @Transactional
    public Participation updateStatus(Long participationId, String status) {
        Participation participation = participationRepository.findById(participationId)
                .orElseThrow(() -> new ResourceNotFoundException("참여기록", participationId));
        participation.setStatus(status);
        return participationRepository.save(participation);
    }
}
