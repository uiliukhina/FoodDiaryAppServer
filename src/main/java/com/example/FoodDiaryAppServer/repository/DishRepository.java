package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findById(long id);
}
