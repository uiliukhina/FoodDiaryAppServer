package com.example.FoodDiaryAppServer.service;

import com.example.FoodDiaryAppServer.model.Dish;

import java.util.List;

public interface DishService {
    Dish add(Dish dish);
    void delete(long id);
    Dish getById(long id);
    Dish edit(Dish dish);
    List<Dish> getAll();
    Dish countCcal(long dishId);
    Dish countProtein(long dishId);
    Dish countFat(long dishId);
    Dish countCarbs(long dishId);


}
