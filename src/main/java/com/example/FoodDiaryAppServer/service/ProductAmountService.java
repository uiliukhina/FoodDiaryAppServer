package com.example.FoodDiaryAppServer.service;


import com.example.FoodDiaryAppServer.model.ProductAmount;

import java.util.List;

public interface ProductAmountService {
    ProductAmount add(ProductAmount productAmount);
    void delete(long id);
    ProductAmount getById(long id);
    ProductAmount edit(ProductAmount productAmount);
    List<ProductAmount> getAll();
//    ProductAmount editName(String name);
//    ProductAmount editCcal(float ccal);
//    ProductAmount editProtein(float protein);
//    ProductAmount editFat(float fat);
//    ProductAmount editCarbs(float carbs);
//    ProductAmount editMeasure(Measure measure);
}
