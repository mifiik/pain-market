package com.dobraccon.pain_market.promotions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductsToPromotionInput {
    private Long promotionId;
    private List<Long> productsIds;
}
