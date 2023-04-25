package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.model.ProductOrder;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    public List<ProductOrder> findAll(){
        return productOrderRepository.findAll();
    }

    public ProductOrder saveOrder(ProductOrder order){
        return productOrderRepository.save(order);
    }
}
