package com.example.FoodDiaryAppServer.service;


import com.example.FoodDiaryAppServer.model.Menu;


import java.util.List;

public interface MenuService {

    Menu add(Menu menu);
    void delete(long id);
    Menu getById(long id);
    Menu edit(Menu menu);
    List<Menu> getAll();
}
