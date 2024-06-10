package com.example.FoodDiaryAppServer.service;


import com.example.FoodDiaryAppServer.model.Day;

import java.sql.Date;
import java.util.List;

public interface DayService {
    Day add(Day day);
    void delete(long id);
    Day getByDate(Date date);
    Day edit(Day day);
    List<Day> getAll();
    Day countCcal(long id);
    Day countProtein(long id);
    Day countFat(long id);
    Day countCarbs(long id);
    Day getById(long id);
    Day getByUser(long userId);
}
