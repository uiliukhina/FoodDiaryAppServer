package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface DayRepository extends JpaRepository<Day, Long> {
    @Query("select d from Day d where d.date = :date")
    Day findByDate(@Param("date")Date date);

    @Query("select d from Day d where d.id = :id")
    Day findById(@Param("id") long id);

    Day findByUser_Id(Long id);
}
