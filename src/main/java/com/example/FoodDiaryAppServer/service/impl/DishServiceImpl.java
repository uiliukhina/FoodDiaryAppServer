package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.Dish;
import com.example.FoodDiaryAppServer.model.ProductAmount;
import com.example.FoodDiaryAppServer.repository.DishRepository;
import com.example.FoodDiaryAppServer.service.DishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish add(Dish dish) {
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public void delete(long id) {
        dishRepository.delete(getById(id));
    }

    @Override
    public Dish getById(long id) {//TODO
        return dishRepository.findById(id);
    }

    @Override
    public Dish edit(Dish dish) {

        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public List<Dish> getAll() {//TODO
        return dishRepository.findAll();
    }

    @Override
    public Dish countCcal(long dishId) {//подсчет калорий для сущности
        Dish dish =  dishRepository.findById(dishId);
        List<ProductAmount> productAmounts = dish.getProductAmounts();
        float sumCcal = 0.0f;
        for (ProductAmount productAmount : productAmounts) {
            sumCcal += productAmount.getCcal();
        }
        dish.setCcal(sumCcal);
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dish countProtein(long dishId) {
        Dish dish =  dishRepository.findById(dishId);
        List<ProductAmount> productAmounts = dish.getProductAmounts();
        float sumProtein = 0.0f;
        for (ProductAmount productAmount : productAmounts) {
            sumProtein += productAmount.getProtein();
        }
        dish.setProtein(sumProtein);
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dish countFat(long dishId) {
        Dish dish =  dishRepository.findById(dishId);
        List<ProductAmount> productAmounts = dish.getProductAmounts();
        float sumFat = 0.0f;
        for (ProductAmount productAmount : productAmounts) {
            sumFat += productAmount.getFat();
        }
        dish.setFat(sumFat);
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dish countCarbs(long dishId) {
        Dish dish =  dishRepository.findById(dishId);
        List<ProductAmount> productAmounts = dish.getProductAmounts();
        float sumCarbs = 0.0f;
        for (ProductAmount productAmount : productAmounts) {
            sumCarbs += productAmount.getCarbs();
        }
        dish.setCarbs(sumCarbs);
        return dishRepository.saveAndFlush(dish);
    }
}
