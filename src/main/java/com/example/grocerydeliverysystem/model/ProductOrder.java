package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int quantity;

    // Many product orders to one product.
    // Hver type produkt skal have én række i produkt tabellen.
    // Vi siger at ProductOrder skal have en foreign key der hedder prodOrderId, som skal være et products productId.
    @ManyToOne
    @JoinColumn(name = "prodOrderId", referencedColumnName = "productId")
    private Product product;

    // Mange product orders til én delivery
    // Vi siger at ProductOrder skal have en foreign key der hedder deliveryId, som skal være en delivery's deliveryId.
    @ManyToOne
    @JoinColumn(name = "deliveryId", referencedColumnName = "deliveryId")
    private Delivery delivery;



}
