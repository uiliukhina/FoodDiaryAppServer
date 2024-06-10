package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.Menu;
import com.example.FoodDiaryAppServer.repository.MenuRepository;
import com.example.FoodDiaryAppServer.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu add(Menu menu) {
        return menuRepository.saveAndFlush(menu);
    }

    @Override
    public void delete(long id) {
        menuRepository.delete(getById(id));
    }

    @Override
    public Menu getById(long id) {//TODO
        return menuRepository.findById(id);
    }

    @Override
    public Menu edit(Menu menu) {//TODO
        return menuRepository.saveAndFlush(menu);
    }

    @Override
    public List<Menu> getAll() {//TODO
        return menuRepository.findAll();
    }
}
