package com.example.orders.controller;

import com.example.orders.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Value("${app.environment}")
    private String environment;

    @GetMapping
    public List<Order> getOrders() {

        return List.of(
                new Order(1001L, "Laptop", 1, "CREATED"),
                new Order(1002L, "Keyboard", 2, "PROCESSING")
        );
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        return new Order(
                id,
                "Laptop",
                1,
                "CREATED"
        );
    }

    @GetMapping("/environment")
    public String environment() {
        return "Running in: " + environment;
    }
}