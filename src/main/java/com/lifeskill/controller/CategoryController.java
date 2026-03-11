package com.lifeskill.controller;

import com.lifeskill.entity.Category;
import com.lifeskill.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units/{unitId}/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategoriesByUnit(@PathVariable Long unitId) {
        return ResponseEntity.ok(curriculumService.getCategoriesByUnit(unitId));
    }
}
