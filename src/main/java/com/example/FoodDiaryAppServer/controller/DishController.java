package com.example.FoodDiaryAppServer.controller;



import com.example.FoodDiaryAppServer.model.Dish;
import com.example.FoodDiaryAppServer.service.DishService;

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
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {
    private DishService dishService;
    @PostMapping("/add/{dish}")
    public Dish addDish(@PathVariable("dish") Dish dish){
        return dishService.add(dish);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable("id") long id){
        dishService.delete(id);
        return new ResponseEntity<>("Dish deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Dish findDish(@PathVariable("id") long id){
        return dishService.getById(id);
    }

    @GetMapping("/get")
    public List<Dish> findAll(){
        return dishService.getAll();
    }

    @PostMapping("/edit/{dish}")
    public Dish editDish(@PathVariable("dish") Dish dish){
        return dishService.edit(dish);
    }
}
