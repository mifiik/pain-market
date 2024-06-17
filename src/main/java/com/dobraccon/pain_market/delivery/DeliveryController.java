package com.dobraccon.pain_market.delivery;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delivery")
@AllArgsConstructor

public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.create(delivery);
    }

    @GetMapping("/{id}")
    public Delivery getById(@PathVariable long id) {
        return deliveryService.getById(id);
    }
}
