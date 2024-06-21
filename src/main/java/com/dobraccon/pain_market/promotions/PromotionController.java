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

    @GetMapping("/{promotionsId}")
    public Promotion getById(@PathVariable long promotionsId) {
        return promotionService.getById(promotionsId);
    }

    @DeleteMapping("/by-id/{promotionsId}")
    public void deleteById(@PathVariable long promotionsId) {
        promotionService.deleteById(promotionsId);
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
    public List<Product> getProductsByPromotionId(@PathVariable long promotionId) {
        return promotionService.getProductsByPromotionId(promotionId);
    }
}



