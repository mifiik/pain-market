package com.dobraccon.pain_market.delivery.deliveryDto;

import com.dobraccon.pain_market.customer.Customer;
import com.dobraccon.pain_market.delivery.DeliveryStatus;
import com.dobraccon.pain_market.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeliveryDTO {
    private Long id;
    private Order order;
    private Customer customer;
    private DeliveryStatus deliveryStatus;
    private String address;
}
