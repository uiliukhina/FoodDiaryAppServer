package com.example.FoodDiaryAppServer.service;


import com.example.FoodDiaryAppServer.model.Weight;


import java.util.List;

public interface WeightService {
    Weight add(Weight product);
    void delete(long id);
    Weight getById(long id);
    Weight edit(Weight user);
    List<Weight> getAll();
    Weight getByUserId(long userId);
//    Weight editWeight(float weight);
//    Weight editDate(Date date);
}
