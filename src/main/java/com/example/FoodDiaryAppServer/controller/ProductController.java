package com.example.FoodDiaryAppServer.controller;


import com.example.FoodDiaryAppServer.model.Product;
import com.example.FoodDiaryAppServer.model.ProductAmount;
import com.example.FoodDiaryAppServer.service.ProductAmountService;
import com.example.FoodDiaryAppServer.service.ProductService;

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

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;
    private ProductAmountService productAmountService;

    @PostMapping("/add/{product}")
    public Product addProduct(@PathVariable("product") Product product){
        return productService.add(product);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Product findProduct(@PathVariable("id") long id){
        return productService.getById(id);
    }

    @GetMapping("/get")
    public List<Product> findAll(){
        return productService.getAll();
    }

    @PostMapping("/edit/{product}")
    public Product editProduct(@PathVariable("product") Product product){
        return productService.edit(product);
    }

    @PostMapping("/amount/add/{productAmount}")
    public ProductAmount addProductAmount(@PathVariable("productAmount") ProductAmount productAmount){
        return productAmountService.add(productAmount);
    }
    @DeleteMapping("/amount/delete/{id}")
    public ResponseEntity<String> deleteProductAmount(@PathVariable("id") long id){
        productAmountService.delete(id);
        return new ResponseEntity<>("ProductAmount deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/amount/get/{id}")
    public ProductAmount findProductAmount(@PathVariable("id") long id){
        return productAmountService.getById(id);
    }

    @GetMapping("/amount/get")
    public List<ProductAmount> findAllAmount(){
        return productAmountService.getAll();
    }

    @PostMapping("/amount/edit/{product}")
    public ProductAmount editProductAmount(@PathVariable("productAmount") ProductAmount productAmount){
        return productAmountService.edit(productAmount);
    }
}
