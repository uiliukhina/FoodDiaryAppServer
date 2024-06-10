package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query("select m from meal m where m.id = :id")
    Meal findById(@Param("id") long id);
}
