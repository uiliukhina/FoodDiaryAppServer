package com.example.FoodDiaryAppServer.service.impl;


import com.example.FoodDiaryAppServer.model.ProductAmount;
import com.example.FoodDiaryAppServer.repository.ProductAmountRepository;
import com.example.FoodDiaryAppServer.service.ProductAmountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAmountServiceImpl implements ProductAmountService {
    @Autowired
    private ProductAmountRepository productAmountRepository;

    @Override
    public ProductAmount add(ProductAmount productAmount) {
        return productAmountRepository.saveAndFlush(productAmount);
    }

    @Override
    public void delete(long id) {
        productAmountRepository.delete(getById(id));
    }

    @Override
    public ProductAmount getById(long id) {//TODO
        return productAmountRepository.findById(id);
    }

    @Override
    public ProductAmount edit(ProductAmount productAmount) {
        return productAmountRepository.saveAndFlush(productAmount);
    }

    @Override
    public List<ProductAmount> getAll() {//TODO
        return productAmountRepository.findAll();
    }

//    @Override
//    public ProductAmount editName(String name) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public ProductAmount editCcal(float ccal) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public ProductAmount editProtein(float protein) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public ProductAmount editFat(float fat) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public ProductAmount editCarbs(float carbs) {//TODO
//        return null;
//    }//TODO
//
//    @Override
//    public ProductAmount editMeasure(Measure measure) {//TODO
//        return null;
//    }//TODO
}
