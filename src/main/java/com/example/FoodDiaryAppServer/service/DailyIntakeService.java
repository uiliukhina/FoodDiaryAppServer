package com.example.FoodDiaryAppServer.service;

import com.example.FoodDiaryAppServer.model.DailyIntake;

public interface DailyIntakeService {
//add delete edit count(4x)
    DailyIntake add(DailyIntake dailyIntake);
    void delete(long id);
    DailyIntake edit(DailyIntake dailyIntake);
    DailyIntake countCcal(long id);
    DailyIntake countProtein(long id);
    DailyIntake countFat(long id);
    DailyIntake countCarbs(long id);
    DailyIntake getByUserId(long userId);
    DailyIntake getById(long id);
}
