package com.lifeskill.service;

import com.lifeskill.dto.ActivityResponse;
import com.lifeskill.entity.Activity;
import com.lifeskill.entity.Category;
import com.lifeskill.entity.Grade;
import com.lifeskill.entity.Unit;
import com.lifeskill.enums.CategoryType;
import com.lifeskill.exception.ResourceNotFoundException;
import com.lifeskill.repository.ActivityRepository;
import com.lifeskill.repository.CategoryRepository;
import com.lifeskill.repository.GradeRepository;
import com.lifeskill.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CurriculumService {

    private final GradeRepository gradeRepository;
    private final UnitRepository unitRepository;
    private final CategoryRepository categoryRepository;
    private final ActivityRepository activityRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAllByOrderByOrderNumAsc();
    }

    public List<Unit> getUnitsByGrade(Long gradeId) {
        return unitRepository.findByGradeIdOrderByOrderNumAsc(gradeId);
    }

    public List<Category> getCategoriesByUnit(Long unitId) {
        return categoryRepository.findByUnitIdOrderByOrderNumAsc(unitId);
    }

    public List<ActivityResponse> getActivitiesByCategory(Long categoryId) {
        List<Activity> activities = activityRepository.findByCategoryIdOrderByOrderNumAsc(categoryId);
        return activities.stream().map(this::toActivityResponse).toList();
    }

    public List<ActivityResponse> getActivitiesByUnitAndType(Long unitId, CategoryType type) {
        Category category = categoryRepository.findByUnitIdAndType(unitId, type)
                .orElseThrow(() -> new ResourceNotFoundException("카테고리", unitId + "/" + type.name()));
        List<Activity> activities = activityRepository.findByCategoryIdOrderByOrderNumAsc(category.getId());
        return activities.stream().map(this::toActivityResponse).toList();
    }

    public ActivityResponse getActivityById(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("활동", activityId));
        return toActivityResponse(activity);
    }

    private ActivityResponse toActivityResponse(Activity activity) {
        return ActivityResponse.builder()
                .id(activity.getId())
                .name(activity.getName())
                .description(activity.getDescription())
                .targetGrade(activity.getTargetGrade())
                .unitLabel(activity.getUnitLabel())
                .guideText(activity.getGuideText())
                .imageUrl(activity.getImageUrl())
                .orderNum(activity.getOrderNum())
                .categoryName(activity.getCategory().getName())
                .unitName(activity.getCategory().getUnit().getName())
                .build();
    }
}
