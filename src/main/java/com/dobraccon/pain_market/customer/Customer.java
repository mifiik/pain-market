package com.dobraccon.pain_market.customer;


import lombok.Getter;

@Getter
public class Customer {
    private final Long id;
    private final String imageUrl;
    private final boolean lawEntity;
    private final String email;
    private final int phoneNumber;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String city;
    private final String street;
    private final int cityIndex;

    public Customer(Long id, String imageUrl, boolean lawEntity, String email, int phoneNumber, String firstName,
                    String lastName, String password, String city, String street, int cityIndex) {
        if (phoneNumber <= 0 || cityIndex <= 0) {
            throw new IllegalArgumentException("Invalid phone number or city index");
        }
        this.id = id;
        this.imageUrl = imageUrl;
        this.lawEntity = lawEntity;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.city = city;
        this.street = street;
        this.cityIndex = cityIndex;
    }
}
