package com.example.FoodDiaryAppServer.controller;

import com.example.FoodDiaryAppServer.model.Day;
import com.example.FoodDiaryAppServer.service.DayService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/day")
@RequiredArgsConstructor
public class DayController {
    private DayService dayService;

    @PostMapping("/add/{day}")
    public Day addDay(@PathVariable("day") Day day){
        return dayService.add(day);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDay(@PathVariable("id") long id){
        dayService.delete(id);
        return new ResponseEntity<>("Day deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Day findDay(@PathVariable("id") long id){
        return dayService.getById(id);
    }

    @GetMapping("/get")
    public List<Day> findAll(){
        return dayService.getAll();
    }

    @PostMapping("/edit/{day}")
    public Day editDay(@PathVariable("day") Day day){
        return dayService.edit(day);
    }
}
