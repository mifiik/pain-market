package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @GetMapping("/by-customer-email/{customerEmail}")
    public Customer loadByEmail(@PathVariable String customerEmail) {
        return customerService.loadByEmail(customerEmail);
    }

    @DeleteMapping("/{customerId}")
    public void deleteById(@PathVariable Long customerId) {
        customerService.deleteById(customerId);
    }

    @DeleteMapping("/by-email/{customerEmail}")
    public void deleteByEmail(@PathVariable String customerEmail) {
        customerService.deleteByEmail(customerEmail);
    }
}
