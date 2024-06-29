package com.dobraccon.pain_market.brand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Brand {
    private final Long id;
    private final String imageUrl;
    private final String name;
}
