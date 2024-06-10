package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.id=:id")
    User findById(@Param("id") long id);
}
