package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.DailyIntake;
import com.example.FoodDiaryAppServer.model.User;
import com.example.FoodDiaryAppServer.model.Weight;
import com.example.FoodDiaryAppServer.repository.DailyIntakeRepository;
import com.example.FoodDiaryAppServer.repository.UserRepository;
import com.example.FoodDiaryAppServer.repository.WeightRepository;
import com.example.FoodDiaryAppServer.service.DailyIntakeService;

public class DailyIntakeServiceImpl implements DailyIntakeService {
    private DailyIntakeRepository dailyIntakeRepository;
    private WeightRepository weightRepository;
    private UserRepository userRepository;
    @Override
    public DailyIntake add(DailyIntake dailyIntake) {
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public void delete(long id) {
        dailyIntakeRepository.deleteDailyIntakeById(id);
    }

    @Override
    public DailyIntake edit(DailyIntake dailyIntake) {
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public DailyIntake countCcal(long userId) {
        DailyIntake dailyIntake = dailyIntakeRepository.findByUser_Id(userId);
        Weight weight = weightRepository.findByUser_Id(userId);
        User user = userRepository.findById(userId);
        float ccal = 0.0f;
        if(user.isGender()) ccal = 10f*weight.getWeight()+6.25f*user.getHeight()-5*user.getAge()-161;
        else ccal = 10f*weight.getWeight()+6.25f*user.getHeight()-5*user.getAge()+5;
        switch (dailyIntake.getCNormal()){
            case FIRST -> ccal = ccal*1.2f;//2 3 6 7 9
            case SECOND -> ccal = ccal*1.3f;
            case THIRD -> ccal = ccal*1.6f;
            case FOURTH -> ccal = ccal*1.7f;
            case FIFTH -> ccal = ccal*1.9f;
        }
        switch (dailyIntake.getGoal()){
            case LOOSE -> {
                ccal= ccal*0.8f;
                break;
            }
            case GAIN -> {
                ccal = ccal*1.2f;
                break;
            }
            case MAINTAIN -> {
                break;
            }
        }
        dailyIntake.setCcal(ccal);
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public DailyIntake countProtein(long userId) {
        DailyIntake dailyIntake = dailyIntakeRepository.findByUser_Id(userId);
        Weight weight = weightRepository.findByUser_Id(userId);

        float protein = weight.getWeight()*1.5f;
        dailyIntake.setProtein(protein);
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public DailyIntake countFat(long userId) {
        DailyIntake dailyIntake = dailyIntakeRepository.findByUser_Id(userId);
        Weight weight = weightRepository.findByUser_Id(userId);

        float fat = weight.getWeight();
        dailyIntake.setFat(fat);
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public DailyIntake countCarbs(long userId) {
        DailyIntake dailyIntake = dailyIntakeRepository.findByUser_Id(userId);
        Weight weight = weightRepository.findByUser_Id(userId);
        float carbs= 0.0f;
        if(dailyIntake.getCcal()!=0 && dailyIntake.getProtein()!=0 && dailyIntake.getFat()!=0 ){
            carbs = (dailyIntake.getCcal() - (dailyIntake.getProtein()*4f+dailyIntake.getFat()*9.3f))/4f;
        }
        else{
            if(dailyIntake.getCcal()==0) this.countCcal(userId);
            if(dailyIntake.getProtein()==0)this.countProtein(userId);
            if(dailyIntake.getFat()==0)this.countFat(userId);
            this.countCarbs(userId);
        }
        dailyIntake.setCarbs(carbs);
        return dailyIntakeRepository.saveAndFlush(dailyIntake);
    }

    @Override
    public DailyIntake getByUserId(long userId) {
        return dailyIntakeRepository.findByUser_Id(userId);
    }

    @Override
    public DailyIntake getById(long id) {
        return dailyIntakeRepository.findDailyIntakeById(id);
    }
}
