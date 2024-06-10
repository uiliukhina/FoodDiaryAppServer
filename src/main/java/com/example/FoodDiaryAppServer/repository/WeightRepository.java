package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Weight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeightRepository extends JpaRepository<Weight, Long> {
    @Query("select w from weight w where w.id=:id")
    Weight findById(@Param("id") long id);

    Weight findByUser_Id(Long userId);
}
