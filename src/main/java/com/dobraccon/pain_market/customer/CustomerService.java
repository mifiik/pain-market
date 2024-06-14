package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void create(Customer customer) {
        customerRepository.create(customer);
    }
}
