package com.lifeskill.controller;

import com.lifeskill.dto.ActivityResponse;
import com.lifeskill.enums.CategoryType;
import com.lifeskill.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActivityController {

    private final CurriculumService curriculumService;

    @GetMapping("/api/categories/{categoryId}/activities")
    public ResponseEntity<List<ActivityResponse>> getActivitiesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(curriculumService.getActivitiesByCategory(categoryId));
    }

    @GetMapping("/api/units/{unitId}/categories/{categoryType}/activities")
    public ResponseEntity<List<ActivityResponse>> getActivitiesByUnitAndType(
            @PathVariable Long unitId,
            @PathVariable String categoryType) {
        CategoryType type = CategoryType.valueOf(categoryType.toUpperCase());
        return ResponseEntity.ok(curriculumService.getActivitiesByUnitAndType(unitId, type));
    }

    @GetMapping("/api/activities/{activityId}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable Long activityId) {
        return ResponseEntity.ok(curriculumService.getActivityById(activityId));
    }
}
