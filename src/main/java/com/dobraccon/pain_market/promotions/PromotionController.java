package com.dobraccon.pain_market.promotions;

import com.dobraccon.pain_market.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@AllArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @PostMapping
    public void create(@RequestBody Promotion promotion) {
        promotionService.create(promotion);
    }

    @GetMapping("/{id}")
    public Promotion getById(@PathVariable Long id) {
        return promotionService.getById(id);
    }

    @DeleteMapping("{promotionId}")
    public void deleteById(@PathVariable Long promotionId) {
        promotionService.deleteById(promotionId);
    }

    @PostMapping("/add-products")
    public void addListOfProductsToPromotion(@RequestBody ProductsToPromotionInput productsToPromotionInput) {
        promotionService.addListOfProductsToPromotion(productsToPromotionInput);
    }

    @GetMapping("/all")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/actual")
    public List<Promotion> getActualPromotions() {
        return promotionService.getActualPromotions();
    }

    @GetMapping("/products-by-promotionId/{promotionId}")
    public List<Product> getProductsByPromotionId(@PathVariable Long promotionId) {
        return promotionService.getProductsByPromotionId(promotionId);
    }
}



