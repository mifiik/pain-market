package com.dobraccon.pain_market.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
   private Long id;
   private Long productId;
   private Long clientId;
   private float price;
}
