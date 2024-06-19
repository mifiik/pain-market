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

    public Customer getById(long id) {
        return customerRepository.getById(id);
    }

    public Customer loadByEmail(String customerEmail) {
        return customerRepository.loadByEmail(customerEmail);
    }

    public void deleteById(long customerId) {
        customerRepository.deleteById(customerId);
    }

    public void deleteByEmail(String customerEmail) {
        customerRepository.deleteByEmail(customerEmail);
    }
}
