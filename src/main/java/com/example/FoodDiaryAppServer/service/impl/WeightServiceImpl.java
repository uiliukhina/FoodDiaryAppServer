package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.Weight;
import com.example.FoodDiaryAppServer.repository.WeightRepository;
import com.example.FoodDiaryAppServer.service.WeightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WeightServiceImpl implements WeightService {
    @Autowired
    private WeightRepository weightRepository;


    @Override
    public Weight add(Weight weight) {
        return weightRepository.saveAndFlush(weight);
    }

    @Override
    public void delete(long id) {
        weightRepository.delete(getById(id));
    }

    @Override
    public Weight getById(long id) { //TODO
        return weightRepository.findById(id);
    }

    @Override
    public Weight edit(Weight weight) { //TODO
        return weightRepository.saveAndFlush(weight);
    }

    @Override
    public List<Weight> getAll() { //TODO
        return weightRepository.findAll();
    }

    @Override
    public Weight getByUserId(long userId) {
        return weightRepository.findByUser_Id(userId);
    }

//    @Override
//    public Weight editWeight(float weight) { //TODO
//        return null;
//    }//TODO
//
//    @Override
//    public Weight editDate(Date date) { //TODO
//        return null;
//    }//TODO
}
