package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }

    public void deleteByDiscount(int productDiscount) {
        productRepository.deleteByDiscount(productDiscount);
    }

    public List<Product> getByCategoryId(long categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public List<Product> getByCategoryGroupId(long groupId) {
        return productRepository.getByCategoryGroupId(groupId);
    }

    public List<Product> getByCatalogId(long catalogId) {
        return productRepository.getByCatalogId(catalogId);
    }
}
