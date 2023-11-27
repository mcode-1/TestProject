package com.example.demo.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    private  final  MealService mealService;

    @Autowired
    public MealController(MealService mealService){
        this.mealService = mealService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body("Meal Added Successfully");
    }

    @GetMapping
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }
}
