package com.lifeskill.controller;

import com.lifeskill.entity.Unit;
import com.lifeskill.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades/{gradeId}/units")
@RequiredArgsConstructor
public class UnitController {

    private final CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<Unit>> getUnitsByGrade(@PathVariable Long gradeId) {
        return ResponseEntity.ok(curriculumService.getUnitsByGrade(gradeId));
    }
}
