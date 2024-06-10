package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.User;
import com.example.FoodDiaryAppServer.repository.UserRepository;
import com.example.FoodDiaryAppServer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(long id) {//TODO
        userRepository.delete(getById(id));
    }

    @Override
    public User getById(long id) {//TODO
        return userRepository.findById(id);
    }

    @Override
    public User edit(User user) {//TODO
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {//TODO
        return userRepository.findAll();
    }

//    @Override
//    public User editName(String name) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public User editHeight(short height) {//TODO
//        return null;
//    }//TODO
}
