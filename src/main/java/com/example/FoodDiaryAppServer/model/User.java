package com.example.FoodDiaryAppServer.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private short height;
    private String user_name;
    private boolean gender;//0-male 1 -female
    private int age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Day> days;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Weight> weights;
}
