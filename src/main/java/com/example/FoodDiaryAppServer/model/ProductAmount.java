package com.example.FoodDiaryAppServer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_amounts")
public class ProductAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    float amount;
    float ccal;
    float protein;
    float fat;
    float carbs;
    @ManyToOne
    @JoinColumn(name = "meals_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "dishes_id")
    private Dish dish;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
