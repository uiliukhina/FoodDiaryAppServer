package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.CanteenDish;
import com.example.FoodDiaryAppServer.repository.CanteenDishRepository;
import com.example.FoodDiaryAppServer.service.CanteenDishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CanteenDishServiceImpl implements CanteenDishService {
    @Autowired
    private CanteenDishRepository canteenDishRepository;

    @Override
    public CanteenDish add(CanteenDish canteenDish) {

        return canteenDishRepository.saveAndFlush(canteenDish);
    }

    @Override
    public void delete(long id) {
        canteenDishRepository.delete(getById(id));
    }

    @Override
    public CanteenDish getById(long id) {
        return canteenDishRepository.findById(id);
    }

    @Override
    public CanteenDish edit(CanteenDish canteenDish) {
        return canteenDishRepository.saveAndFlush(canteenDish);
    }

    @Override
    public List<CanteenDish> getAll() {
        return canteenDishRepository.findAll();
    }

    @Override
    public CanteenDish getByName(String name) {
        return canteenDishRepository.findByDishName(name);
    }

//    @Override
//    public CanteenDish editAmount(float amount) { //TODO
//        return null;
//    } //TODO
//
//    @Override
//    public CanteenDish editMeasure(Measure measure) { //TODO
//        return null;
//    } //TODO
}
