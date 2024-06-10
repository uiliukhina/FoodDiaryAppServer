package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.DailyIntake;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DailyIntakeRepository extends JpaRepository<DailyIntake, Long> {
    void deleteDailyIntakeById(long id);
    DailyIntake findDailyIntakeById(long id);

    DailyIntake findByUser_Id(Long id);
}
