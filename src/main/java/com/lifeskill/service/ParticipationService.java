package com.lifeskill.service;

import com.lifeskill.entity.Activity;
import com.lifeskill.entity.Participation;
import com.lifeskill.entity.User;
import com.lifeskill.repository.ActivityRepository;
import com.lifeskill.repository.ParticipationRepository;
import com.lifeskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        Participation participation = Participation.builder()
                .user(user)
                .activity(activity)
                .fileUrl(fileUrl)
                .reviewText(reviewText)
                .status("PENDING")
                .build();

        return participationRepository.save(participation);
    }

    @Transactional(readOnly = true)
    public List<Participation> getMyParticipations(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return participationRepository.findByUserIdOrderBySubmittedAtDesc(user.getId());
    }

    @Transactional(readOnly = true)
    public List<Participation> getParticipationsByActivity(Long activityId) {
        return participationRepository.findByActivityId(activityId);
    }
}
