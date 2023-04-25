package com.example.grocerydeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;
    private LocalDate deliveryDate;
    private String warehouse;
    private String destination;

    // Én type produkt kan tilhøre mange orders. "delivery"" peger bare på klassen.
    @OneToMany(mappedBy = "delivery")
    @JsonBackReference // Gør bare at der ikke opstår en json bug, når du skriver json ud.
    private Set<ProductOrder> productOrders = new HashSet<>();


}
