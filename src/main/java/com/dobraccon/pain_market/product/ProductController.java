package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable Long productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("/by-product-discount/{productDiscount}")
    public void deleteByDiscount(@PathVariable int productDiscount) {
        productService.deleteByDiscount(productDiscount);
    }

    @GetMapping("/get-by-category-id/{categoriesId}")
    public List<Product> getByCategoriesId(@PathVariable long categoriesId) {
        return productService.getByCategoriesId(categoriesId);
    }

    @GetMapping("/get-by-groups-categories-id/{groupId}")
    public List<Product> getByCategoryGroupId(@PathVariable long groupId) {
        return productService.getByCategoryGroupId(groupId);
    }

    @GetMapping("/get-by-catalog-id/{catalogId}")
    public List<Product> getByCatalogId(@PathVariable long catalogId) {
        return productService.getByCatalogId(catalogId);
    }
}
