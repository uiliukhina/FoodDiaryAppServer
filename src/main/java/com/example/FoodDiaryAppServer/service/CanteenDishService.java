package com.example.FoodDiaryAppServer.service;

import com.example.FoodDiaryAppServer.model.CanteenDish;

//блюдо в столовой
import java.util.List;

public interface CanteenDishService {
    CanteenDish add(CanteenDish canteenDish);
    void delete(long id);
    CanteenDish getById(long id);
    CanteenDish edit(CanteenDish canteenDish);
    List<CanteenDish> getAll();
    CanteenDish getByName(String name);
//    CanteenDish editAmount(float amount);
//    CanteenDish editMeasure(Measure measure);
}
