package com.example.FoodDiaryAppServer.model;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Time meal_time;
    String meal_name;
    float ccal;
    float protein;
    float fat;
    float carbs;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @OneToMany
    private List<ProductAmount> productAmounts;

    @OneToMany
    private List<Dish> dishes;
}
