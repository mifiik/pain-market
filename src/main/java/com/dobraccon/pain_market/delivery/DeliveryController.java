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
    public Delivery getById(@PathVariable Long id) {
        return deliveryService.getById(id);
    }

    @DeleteMapping("/delete-by-delivery-id/{deliveryId}")
    public void deleteByDeliveryId(@PathVariable Long deliveryId) {
        deliveryService.deleteByDeliveryId(deliveryId);
    }

    @DeleteMapping("/delete-by-delivery-address/{deliveryAddress}")
    public void deleteByAddress(@PathVariable String deliveryAddress) {
        deliveryService.deleteByAddress(deliveryAddress);
    }

    @DeleteMapping("/delete-by-delivery-order-and-customer-id/{orderId}/{customerId}")
    public void deleteByOrderIdAndCustomerId(@PathVariable long orderId, @PathVariable long customerId) {
        deliveryService.deleteByOrderIdAndCustomerId(orderId, customerId);
    }
}
