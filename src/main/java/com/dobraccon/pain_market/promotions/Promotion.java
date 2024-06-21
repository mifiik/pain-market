package com.dobraccon.pain_market.promotions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Promotion {
    private Long id;
    private String imageUrl;
    private String promotionName;
    private String promotionDescription;
    private boolean isPromotionActual;
}
