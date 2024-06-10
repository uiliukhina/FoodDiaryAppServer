package com.example.FoodDiaryAppServer.repository;

import com.example.FoodDiaryAppServer.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.id=:id")
    Product findById(@Param("id") long id);
}
