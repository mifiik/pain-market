package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Delivery {
    private Long id;
    private long orderId;
    private long customerId;
    private long statusId;
    private String address;
}
