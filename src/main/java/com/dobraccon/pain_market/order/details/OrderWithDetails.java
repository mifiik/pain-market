package com.dobraccon.pain_market.order.details;

import com.dobraccon.pain_market.customer.Customer;
import com.dobraccon.pain_market.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class OrderWithDetails {
    private Long orderId;
    private Product product;
    private Customer orderCustomer;
}
