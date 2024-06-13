package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Product {
    private Long id;
    private String name;
    private float price;
    private int discount;

    public Product(Long id, String name, float price, int discount) {
        if (price <= 0 || discount < 0 || discount >= 100) {
            throw new IllegalArgumentException("Invalid price or discount");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public float discountCalculation() {
        return price - (price / 100 * discount);
    }
}
