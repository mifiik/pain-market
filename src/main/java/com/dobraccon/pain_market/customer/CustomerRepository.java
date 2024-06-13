package com.dobraccon.pain_market.customer;


import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    public Customer create(Customer customer){
        long newId =(long)(Math.random()*Long.MAX_VALUE);
        return new Customer(newId, customer.getEmail());
    }
}
