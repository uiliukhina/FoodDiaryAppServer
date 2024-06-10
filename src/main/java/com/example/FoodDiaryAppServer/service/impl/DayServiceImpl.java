package com.example.FoodDiaryAppServer.service.impl;



import com.example.FoodDiaryAppServer.model.Day;
import com.example.FoodDiaryAppServer.model.Meal;
import com.example.FoodDiaryAppServer.repository.DayRepository;
import com.example.FoodDiaryAppServer.service.DayService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    @Autowired
    private DayRepository dayRepository;
    @Override
    public Day add(Day day) {
        return dayRepository.saveAndFlush(day);
    }

    @Override
    public void delete(long id) {
        dayRepository.delete(getById(id));
    }

    @Override
    public Day getById(long id) {//TODO
        return dayRepository.findById(id);
    }

    @Override
    public Day getByUser(long userId) {
        return dayRepository.findByUser_Id(userId);
    }

    @Override
    public Day getByDate(Date date) {//TODO
        return dayRepository.findByDate(date);
    }

    @Override
    public Day edit(Day day) {
        return dayRepository.saveAndFlush(day);
    }

    @Override
    public List<Day> getAll() {//TODO
        return dayRepository.findAll();
    }



    @Override
    public Day countCcal(long id) {//TODO
        Day day = dayRepository.findById(id);
        List<Meal> meals = day.getMeals();
        float sumCcal=0.0f;
        for(Meal meal: meals){
            sumCcal+=meal.getCcal();
        }
        day.setCcal(sumCcal);
        return dayRepository.saveAndFlush(day);
    }//TODO

    @Override
    public Day countProtein(long id) {
        Day day = dayRepository.findById(id);
        List<Meal> meals = day.getMeals();
        float sumProtein=0.0f;
        for(Meal meal: meals){
            sumProtein+=meal.getProtein();
        }
        day.setProtein(sumProtein);
        return dayRepository.saveAndFlush(day);
    }

    @Override
    public Day countFat(long id) {
        Day day = dayRepository.findById(id);
        List<Meal> meals = day.getMeals();
        float sumFat=0.0f;
        for(Meal meal: meals){
            sumFat+=meal.getFat();
        }
        day.setFat(sumFat);
        return dayRepository.saveAndFlush(day);
    }

    @Override
    public Day countCarbs(long id) {
        Day day = dayRepository.findById(id);
        List<Meal> meals = day.getMeals();
        float sumCarbs=0.0f;
        for(Meal meal: meals){
            sumCarbs+=meal.getCarbs();
        }
        day.setCarbs(sumCarbs);
        return dayRepository.saveAndFlush(day);
    }
}
