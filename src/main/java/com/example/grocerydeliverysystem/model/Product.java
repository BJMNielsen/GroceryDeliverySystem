package com.example.grocerydeliverysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok constructors og setters/getters.
// JPA skal altid bruge en tom constructor
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Vi bruger ikke GenerationType.AUTO, fordi den laver en hjælpetabel der viser, hvad det næste ID er.
    // Det gør IDENTITY ikke. Man kan self godt, men vi skal ikke bruge tabellen til noget.
    private long id;

    private String name;
    private double price;
    private double weight;




}
