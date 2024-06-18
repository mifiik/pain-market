package com.dobraccon.pain_market.order;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void create(Order order) {
        orderRepository.create(order);
    }

    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    public void deleteByOrderId(long orderId) {
        orderRepository.deleteByOrderId(orderId);
    }

    public void deleteByPrice(float orderPrice) {
        orderRepository.deleteByPrice(orderPrice);
    }

    public void deleteByClientId(long clientId) {
        orderRepository.deleteByClientId(clientId);
    }
}
