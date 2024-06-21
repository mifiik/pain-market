package com.dobraccon.pain_market.promotions;

import com.dobraccon.pain_market.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public void create(Promotion promotion) {
        promotionRepository.create(promotion);
    }

    public Promotion getById(long promotionsId) {
        return promotionRepository.getById(promotionsId);
    }

    public void deleteById(long promotionsId) {
        promotionRepository.deleteById(promotionsId);
    }

    public void addListOfProductsToPromotion(ProductsToPromotionInput productsToPromotionInput) {
        promotionRepository.addListOfProductsToPromotion(productsToPromotionInput);
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.getAllPromotions();
    }

    public List<Promotion> getActualPromotions() {
        return promotionRepository.getActualPromotions();
    }

    public List<Product> getProductsByPromotionId(long promotionId) {
        return promotionRepository.getProductsByPromotionId(promotionId);
    }
}



