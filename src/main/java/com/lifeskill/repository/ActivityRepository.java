package com.lifeskill.repository;

import com.lifeskill.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCategoryIdOrderByOrderNumAsc(Long categoryId);
}
