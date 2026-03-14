package com.lifeskill.repository;

import com.lifeskill.entity.Participation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUserIdOrderBySubmittedAtDesc(Long userId);
    List<Participation> findByActivityId(Long activityId);
    Page<Participation> findByUserId(Long userId, Pageable pageable);
    Page<Participation> findByActivityId(Long activityId, Pageable pageable);
    Page<Participation> findAll(Pageable pageable);
    Page<Participation> findByStatus(String status, Pageable pageable);
    Page<Participation> findByUserIdAndStatus(Long userId, String status, Pageable pageable);
    long countByUserId(Long userId);
    long countByStatus(String status);
    Page<Participation> findByUserIdIn(List<Long> userIds, Pageable pageable);
    Page<Participation> findByUserIdInAndStatus(List<Long> userIds, String status, Pageable pageable);
    long countByUserIdIn(List<Long> userIds);
    long countByUserIdInAndStatus(List<Long> userIds, String status);
}
