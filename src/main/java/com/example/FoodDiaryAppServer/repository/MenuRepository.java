package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("select m from menu where m.id = :id")
    Menu findById(@Param("id")long id);
}
