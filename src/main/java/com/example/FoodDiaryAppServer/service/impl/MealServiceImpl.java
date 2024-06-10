package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.Dish;
import com.example.FoodDiaryAppServer.model.Meal;
import com.example.FoodDiaryAppServer.model.ProductAmount;
import com.example.FoodDiaryAppServer.repository.MealRepository;
import com.example.FoodDiaryAppServer.service.MealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;

    @Override
    public Meal add(Meal meal) {
        return mealRepository.saveAndFlush(meal);
    }

    @Override
    public void delete(long id) {
        mealRepository.delete(getById(id));
    }

    @Override
    public Meal getById(long id) {//TODO
        return mealRepository.findById(id);
    }

    @Override
    public Meal edit(Meal meal) {//TODO
        return mealRepository.saveAndFlush(meal);
    }

    @Override
    public List<Meal> getAll() {//TODO
        return mealRepository.findAll();
    }



    @Override
    public Meal countCcal(long id) {
        Meal meal = mealRepository.findById(id);
        List<Dish> dishes = meal.getDishes();
        List<ProductAmount> productAmounts = meal.getProductAmounts();
        float sumCcal = 0.0f;
        for(Dish dish: dishes){
            sumCcal+=dish.getCcal();
        }
        for(ProductAmount productAmount: productAmounts){
            sumCcal+= productAmount.getCcal();
        }
        meal.setCcal(sumCcal);
        return mealRepository.saveAndFlush(meal);
    }

    @Override
    public Meal countProtein(long id) {
        Meal meal = mealRepository.findById(id);
        List<Dish> dishes = meal.getDishes();
        List<ProductAmount> productAmounts = meal.getProductAmounts();
        float sumProtein = 0.0f;
        for(Dish dish: dishes){
            sumProtein+=dish.getProtein();
        }
        for(ProductAmount productAmount: productAmounts){
            sumProtein+= productAmount.getProtein();
        }
        meal.setProtein(sumProtein);
        return mealRepository.saveAndFlush(meal);
    }

    @Override
    public Meal countFat(long id) {
        Meal meal = mealRepository.findById(id);
        List<Dish> dishes = meal.getDishes();
        List<ProductAmount> productAmounts = meal.getProductAmounts();
        float sumFat = 0.0f;
        for(Dish dish: dishes){
            sumFat+=dish.getFat();
        }
        for(ProductAmount productAmount: productAmounts){
            sumFat+= productAmount.getFat();
        }
        meal.setFat(sumFat);
        return mealRepository.saveAndFlush(meal);
    }

    @Override
    public Meal countCarbs(long id) {
        Meal meal = mealRepository.findById(id);
        List<Dish> dishes = meal.getDishes();
        List<ProductAmount> productAmounts = meal.getProductAmounts();
        float sumCarbs = 0.0f;
        for(Dish dish: dishes){
            sumCarbs+=dish.getCarbs();
        }
        for(ProductAmount productAmount: productAmounts){
            sumCarbs+= productAmount.getCarbs();
        }
        meal.setCarbs(sumCarbs);
        return mealRepository.saveAndFlush(meal);
    }
}
