package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete-by-product-id/{productId}")
    public void deleteById(@PathVariable Long productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("/delete-by-product-name/{productName}")
    public void deleteByName(@PathVariable String productName) {
        productService.deleteByName(productName);
    }

    @DeleteMapping("/delete-by-product-discount/{productDiscount}")
    public void deleteByDiscount(@PathVariable int productDiscount) {
        productService.deleteByDiscount(productDiscount);
    }
}
