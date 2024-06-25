package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Delivery {
    private Long id;
    private Long orderId;
    private Long customerId;
    private Long statusId;
    private String address;
}
