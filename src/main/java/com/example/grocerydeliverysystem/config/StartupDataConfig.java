package com.example.grocerydeliverysystem.config;

import com.example.grocerydeliverysystem.model.Delivery;
import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.model.ProductOrder;
import com.example.grocerydeliverysystem.repository.DeliveryRepository;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

//@Configuration annotationen og ApplicationRunner klassen gør at run metoden køre når applikationen starter.
@Configuration
public class StartupDataConfig implements ApplicationRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Vi laver et produkt og giver det værdier.
        Product product1 = new Product();
        product1.setName("Æble");
        product1.setPrice(5);
        product1.setWeight(50);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Mælk");
        product2.setPrice(11.5);
        product2.setWeight(1000);
        productRepository.save(product2);

        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(LocalDate.now());
        delivery.setWarehouse("Warehouse1");
        delivery.setDestination("Havnevej 2 4000 Roskilde");
        deliveryRepository.save(delivery);

        ProductOrder order1 = new ProductOrder();
        order1.setProduct(product1);
        //order1.setProduct(product2);
        order1.setQuantity(10);
        order1.setDelivery(delivery);
        productOrderRepository.save(order1);

        ProductOrder order2 = new ProductOrder();
        order2.setProduct(product2);
        order2.setQuantity(10);
        order2.setDelivery(delivery);
        productOrderRepository.save(order2);

    }
}
