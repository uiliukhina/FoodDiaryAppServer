package com.example.FoodDiaryAppServer.controller;

import com.example.FoodDiaryAppServer.model.Dish;
import com.example.FoodDiaryAppServer.model.Meal;
import com.example.FoodDiaryAppServer.service.MealService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {
    private MealService mealService;
    @PostMapping("/add/{meal}")
    public Meal addMeal(@PathVariable("meal") Meal meal){
        return mealService.add(meal);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMeal(@PathVariable("id") long id){
        mealService.delete(id);
        return new ResponseEntity<>("Meal deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Meal findMeal(@PathVariable("id") long id){
        return mealService.getById(id);
    }

    @GetMapping("/get")
    public List<Meal> findAll(){
        return mealService.getAll();
    }

    @PostMapping("/edit/{meal}")
    public Meal editMeal(@PathVariable("meal") Meal meal){
        return mealService.edit(meal);
    }
}
