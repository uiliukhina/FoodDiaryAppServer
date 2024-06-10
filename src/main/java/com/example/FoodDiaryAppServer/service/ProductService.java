package com.example.FoodDiaryAppServer.service;


import com.example.FoodDiaryAppServer.model.Product;


import java.util.List;

public interface ProductService {

    Product add(Product product);
    void delete(long id);
    Product getById(long id);
    Product edit(Product product);
    List<Product> getAll();


}
