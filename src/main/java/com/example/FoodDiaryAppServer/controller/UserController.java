package com.example.FoodDiaryAppServer.controller;


import com.example.FoodDiaryAppServer.model.User;
import com.example.FoodDiaryAppServer.model.Weight;
import com.example.FoodDiaryAppServer.service.UserService;
import com.example.FoodDiaryAppServer.service.WeightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;
//работа с WeightService и UserService
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    private WeightService weightService;

    @PostMapping("/add/{user}")
    public User addUser(@PathVariable("product") User user){
        return userService.add(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public User findUser(@PathVariable("id") long id){
        return userService.getById(id);
    }

    @GetMapping("/get")
    public List<User> findAll(){
        return userService.getAll();
    }

    @PostMapping("/edit/{user}")
    public User editUser(@PathVariable("user") User user){
        return userService.edit(user);
    }

    @PostMapping("/add/{weight}")
    public Weight addWeight(@PathVariable("weight") Weight weight){
        return weightService.add(weight);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWeight(@PathVariable("id") long id){
        weightService.delete(id);
        return new ResponseEntity<>("Weight deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Weight findWeight(@PathVariable("id") long id){
        return weightService.getById(id);
    }

    @GetMapping("/get")
    public List<Weight> findAllWeight(){
        return weightService.getAll();
    }

    @PostMapping("/edit/{weight}")
    public Weight editWeight(@PathVariable("weight") Weight weight){
        return weightService.edit(weight);
    }

}
