package com.dobraccon.pain_market.order;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void create(Order order){
        orderRepository.create(order);
    }
}
