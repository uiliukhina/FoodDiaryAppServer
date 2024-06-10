package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.CanteenDish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CanteenDishRepository extends JpaRepository<CanteenDish, Long>{
    CanteenDish findById(long id);
    @Query("SELECT cd FROM CanteenDish cd WHERE cd.dish_name = :dishName")
    CanteenDish findByDishName(@Param("dishName") String dishName);
}
