package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.create(customer);
    }
}
