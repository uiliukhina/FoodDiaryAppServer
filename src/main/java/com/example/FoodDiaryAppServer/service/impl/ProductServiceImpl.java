package com.example.FoodDiaryAppServer.service.impl;

import com.example.FoodDiaryAppServer.model.Product;
import com.example.FoodDiaryAppServer.repository.ProductRepository;
import com.example.FoodDiaryAppServer.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public void delete(long id) {//TODO
        productRepository.delete(getById(id));
    }

    @Override
    public Product getById(long id) {//TODO
        return productRepository.findById(id);
    }

    @Override
    public Product edit(Product product) {//TODO
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAll() {//TODO
        return productRepository.findAll();
    }
}
