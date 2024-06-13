package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.create(product);
    }
}
