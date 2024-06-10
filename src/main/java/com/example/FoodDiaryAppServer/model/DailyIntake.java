package com.example.FoodDiaryAppServer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="daily_intakes")
public class DailyIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    float ccal;
    float protein;
    float fat;
    float carbs;
    Goal goal;
    CoefficientJob cJob;
    CoefficientNormal cNormal;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
