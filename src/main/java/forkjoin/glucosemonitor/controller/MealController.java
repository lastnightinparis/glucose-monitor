package forkjoin.glucosemonitor.controller;

import forkjoin.glucosemonitor.dto.MealDto;
import forkjoin.glucosemonitor.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {
    private MealService mealService;

    @GetMapping("/list")
    public ResponseEntity<List<MealDto>> getAllMeals() {
        return ResponseEntity.ok(mealService.findAll());
    }
}
