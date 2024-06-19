package com.dobraccon.pain_market.order.history;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderHistoryDTO {
    private long customerId;
    private String customerEmail;
    private List<CustomerOrderDTO> customerOrders;
}
