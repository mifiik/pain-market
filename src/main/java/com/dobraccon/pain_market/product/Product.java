package com.dobraccon.pain_market.product;


import lombok.Getter;

@Getter
public class Product {
    private final Long id;
    private final float primaryPrice;
    private final float currentPrice;
    private final int discount;
    private final boolean isNew;
    private final String imageURL;
    private final String description;
    private final int minDeliveryDays;
    private final int maxDeliveryDays;
    private final float rating;
    private final int reviewCount;


    public Product(Long id, float primaryPrice, float currentPrice, int discount, boolean isNew, String imageURL,
                   String description, int minDeliveryDays, int maxDeliveryDays, float rating, int reviewCount) {
        if (primaryPrice < 0 || currentPrice < 0 || discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Invalid price or discount");
        }
        this.id = id;
        this.primaryPrice = primaryPrice;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.isNew = isNew;
        this.imageURL = imageURL;
        this.description = description;
        this.minDeliveryDays = minDeliveryDays;
        this.maxDeliveryDays = maxDeliveryDays;
        this.rating = rating;
        this.reviewCount = reviewCount;
    }

    public float discountCalculation() {
        return primaryPrice - (primaryPrice * discount / 100);
    }
}
