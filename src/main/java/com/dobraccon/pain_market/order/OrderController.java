package com.dobraccon.pain_market.order;

import com.dobraccon.pain_market.order.details.OrderWithDetails;
import com.dobraccon.pain_market.order.history.OrderHistoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @DeleteMapping("/{orderId}")
    public void deleteByOrderId(@PathVariable Long orderId) {
        orderService.deleteByOrderId(orderId);
    }

    @DeleteMapping("/by-price/{orderPrice}")
    public void deleteByPrice(@PathVariable float orderPrice) {
        orderService.deleteByPrice(orderPrice);
    }

    @DeleteMapping("/by-client-id/{clientId}")
    public void deleteByClientId(@PathVariable Long clientId) {
        orderService.deleteByClientId(clientId);
    }

    @GetMapping("/by-order-id-with-detail/{orderId}")
    public OrderWithDetails getByOrderIdWithDetails(@PathVariable Long orderId) {
        return orderService.getByOrderIdWithDetails(orderId);
    }

    @GetMapping("/history-by-customer-id/{customerId}")
    public OrderHistoryDTO getCustomerOrders(@PathVariable Long customerId) {
        return orderService.getCustomerOrders(customerId);
    }
}
