package com.lifeskill.repository;

import com.lifeskill.entity.Category;
import com.lifeskill.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUnitIdOrderByOrderNumAsc(Long unitId);
    Optional<Category> findByUnitIdAndType(Long unitId, CategoryType type);
}
