package com.lifeskill.repository;

import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByKakaoId(String kakaoId);
    boolean existsByUsername(String username);
    List<User> findByRole(UserRole role);
    Page<User> findByRole(UserRole role, Pageable pageable);
    Page<User> findByRoleAndSchoolAndGradeAndClassNum(UserRole role, String school, Integer grade, Integer classNum, Pageable pageable);
    List<User> findByRoleAndSchoolAndGradeAndClassNum(UserRole role, String school, Integer grade, Integer classNum);
}
