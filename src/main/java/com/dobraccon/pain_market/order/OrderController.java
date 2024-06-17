package com.dobraccon.pain_market.order;

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
    public Order getById(@PathVariable long id) {
        return orderService.getById(id);
    }
}
