package com.example.grocerydeliverysystem.repository;

import com.example.grocerydeliverysystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
