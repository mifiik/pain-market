package com.dobraccon.pain_market.delivery;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delivery")
@AllArgsConstructor

public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.create(delivery);
    }
}
