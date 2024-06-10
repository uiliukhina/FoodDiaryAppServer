package com.example.FoodDiaryAppServer.service;

import com.example.FoodDiaryAppServer.model.Meal;


import java.util.List;

public interface MealService {

    Meal add(Meal meal);
    void delete(long id);
    Meal getById(long id);
    Meal edit(Meal meal);
    List<Meal> getAll();
    Meal countCcal(long id);
    Meal countProtein(long id);
    Meal countFat(long id);
    Meal countCarbs(long id);
}
