package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import com.example.grocerydeliverysystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRESTController {

    @Autowired
    ProductService productService;



    @GetMapping("/products")
    public List<Product> products(){
        return productService.findAll();
    }


}
