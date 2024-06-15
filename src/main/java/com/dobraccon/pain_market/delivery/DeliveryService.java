package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public void create(Delivery delivery) {
        deliveryRepository.create(delivery);
    }
}
