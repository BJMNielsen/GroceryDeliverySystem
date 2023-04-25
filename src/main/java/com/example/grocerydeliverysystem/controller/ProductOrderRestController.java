package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.ProductOrder;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import com.example.grocerydeliverysystem.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductOrderRestController {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    ProductOrderService productOrderService;

    @GetMapping("/productorders")
    public List<ProductOrder> products() {
        return productOrderService.findAll();
    }

    // RequestBody tager json og laver til et java object.
    // In Spring, @RequestBody is an annotation used in web controllers to bind the request body
    // (which contains the payload of the HTTP request) to a Java object.
    // It is used to extract the request body and map it to a Java object so that it can be used in the application.
    @PostMapping("/order")
    public ProductOrder addOrder(@RequestBody ProductOrder order) {
        // Check postman, jeg har lavet en post hvor vi prøver at sende noget json og se om det bliver lagt ned i databasen.
        // En postrequest skal bruge 3 ting i json format, quantity, delivery_id og prod_order_id (se product_order tabellen i SQL)
        try {
            productOrderService.saveOrder(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @PutMapping("/order")
    public ProductOrder updateOrder(@RequestBody ProductOrder order) {
        // her kalder vi bare repo direkte
        Optional<ProductOrder> po = productOrderRepository.findById(order.getOrderId());

        if(po.isPresent()) {
            productOrderRepository.save(order);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordre linje ikke fundet");
        }
        return order;
    }
}
