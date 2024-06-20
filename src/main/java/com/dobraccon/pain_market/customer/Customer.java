package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private final Long id;
    private final String imageUrl;
    private final boolean legalEntity;
    private final String email;
    private final String phoneNumber;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String city;
    private final String street;
    private final String cityIndex;
}
