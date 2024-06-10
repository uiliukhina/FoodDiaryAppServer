package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.ProductAmount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductAmountRepository extends JpaRepository<ProductAmount, Long> {
    @Query("select p from ProductAmount p where p.id=:id")
    ProductAmount findById(@Param("id") long id);
}
