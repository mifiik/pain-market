package com.dobraccon.pain_market.product;


import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public Product create(Product product) {
        long newId = (long) (Math.random() * Long.MAX_VALUE);
        return new Product(newId, product.getName(), product.getPrice(), product.getDiscount());
    }
}
