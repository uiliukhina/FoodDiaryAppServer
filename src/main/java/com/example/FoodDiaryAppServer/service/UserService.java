package com.example.FoodDiaryAppServer.service;

import com.example.FoodDiaryAppServer.model.User;

import java.util.List;

public interface UserService {
    User add(User product);
    void delete(long id);
    User getById(long id);
    User edit(User user);
    List<User> getAll();
//    User editName(String name);
//    User editHeight(short height);
}
