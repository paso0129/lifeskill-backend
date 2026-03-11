package com.lifeskill.repository;

import com.lifeskill.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUserIdOrderBySubmittedAtDesc(Long userId);
    List<Participation> findByActivityId(Long activityId);
}
