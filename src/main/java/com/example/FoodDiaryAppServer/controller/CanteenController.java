package com.example.FoodDiaryAppServer.controller;

import com.example.FoodDiaryAppServer.model.CanteenDish;
import com.example.FoodDiaryAppServer.model.Menu;
import com.example.FoodDiaryAppServer.service.CanteenDishService;
import com.example.FoodDiaryAppServer.service.MenuService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;
//контроллер для работы со столовой
@RestController
@RequestMapping("/canteen")
@RequiredArgsConstructor
public class CanteenController {
    private CanteenDishService canteenDishService;
    private MenuService menuService;

//    public CanteenController(CanteenDishService canteenDishService, MenuService menuService) {
//        this.canteenDishService = canteenDishService;
//        this.menuService = menuService;
//    }
//  для MenuService

    @PostMapping("/menu/add/{menu}")
    public Menu addMenu(@RequestBody Menu menu){
        return menuService.add(menu);
    }
    @DeleteMapping("/menu/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") long id){
        menuService.delete(id);
        return new ResponseEntity<>("Canteen dish has been deleted", HttpStatus.OK);
    }
    @GetMapping("/menu/get/{id}")
    public Menu findMenu(@PathVariable("id") long id){
        return menuService.getById(id);
    }

    @GetMapping("/menu/get")
    public List<Menu> findAllMenu(){
        return menuService.getAll();
    }

    @PostMapping("/menu/edit/{menu}")
    public Menu editMenu(@PathVariable("menu") Menu menu){
        return menuService.edit(menu);
    }

// для CanteenDishService
    @PostMapping("/dishes/add/{canteenDish}")
    public CanteenDish addCanteenDish(@RequestBody CanteenDish canteenDish) {
        return canteenDishService.add(canteenDish);
    }
    @DeleteMapping("/dishes/delete/{id}")
    public ResponseEntity<String> deleteCanteenDish(@PathVariable("id") long id) {
        canteenDishService.delete(id);
        return new ResponseEntity<>("Canteen dish has been deleted", HttpStatus.OK);
    }

    @GetMapping("/dishes/get/{id}")
    public CanteenDish findCanteenDish(@PathVariable("id") long id){
        return canteenDishService.getById(id);
    }

    @GetMapping("/dishes/get")
    public List<CanteenDish> findAllDishes(){
        return canteenDishService.getAll();
    }

    @PostMapping("/dishes/edit/{canteenDish}")
    public CanteenDish editCanteenDish(@PathVariable("canteenDish") CanteenDish canteenDish){
        return canteenDishService.edit(canteenDish);
    }
}
