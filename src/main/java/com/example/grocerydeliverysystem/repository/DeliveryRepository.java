package com.example.grocerydeliverysystem.repository;

import com.example.grocerydeliverysystem.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
