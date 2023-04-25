package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
