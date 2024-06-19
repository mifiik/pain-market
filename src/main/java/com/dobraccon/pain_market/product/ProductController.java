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

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable Long productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("/by-product-discount/{productDiscount}")
    public void deleteByDiscount(@PathVariable int productDiscount) {
        productService.deleteByDiscount(productDiscount);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }
}
