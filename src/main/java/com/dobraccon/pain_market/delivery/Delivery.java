package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Delivery {
    private Long id;
    private Long order_id;
    private Long customer_id;
    private String address;
}
