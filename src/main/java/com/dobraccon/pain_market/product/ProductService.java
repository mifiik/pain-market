package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void create(Product product) {
        productRepository.create(product);
    }

    public Product getById(long id) {
        return productRepository.getById(id);
    }
}
