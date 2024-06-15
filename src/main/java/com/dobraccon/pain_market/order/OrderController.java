package com.dobraccon.pain_market.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }
}
