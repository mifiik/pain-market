package com.dobraccon.pain_market.order.history;

import com.dobraccon.pain_market.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerOrderDTO {
    long orderId;
    Product orderProduct;
    long customerId;
    float price;
}
