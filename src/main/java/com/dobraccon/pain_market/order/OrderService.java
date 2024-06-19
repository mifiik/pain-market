package com.dobraccon.pain_market.order;


import com.dobraccon.pain_market.customer.Customer;
import com.dobraccon.pain_market.customer.CustomerService;
import com.dobraccon.pain_market.order.details.OrderWithDetails;
import com.dobraccon.pain_market.order.history.CustomerOrderDTO;
import com.dobraccon.pain_market.order.history.OrderHistoryDTO;
import com.dobraccon.pain_market.product.Product;
import com.dobraccon.pain_market.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CustomerService customerService;

    public void create(Order order) {
        orderRepository.create(order);
    }

    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    public void deleteByOrderId(long orderId) {
        orderRepository.deleteByOrderId(orderId);
    }

    public void deleteByPrice(float orderPrice) {
        orderRepository.deleteByPrice(orderPrice);
    }

    public void deleteByClientId(long clientId) {
        orderRepository.deleteByClientId(clientId);
    }

    public OrderWithDetails getByOrderIdWithDetails(long orderId) {
        Order order = orderRepository.getById(orderId);
        Product orderProduct = productService.getById(order.getProductId());
        Customer orderCustomer = customerService.getById(order.getClientId());

        return new OrderWithDetails(
                order.getId(),
                orderProduct,
                orderCustomer);
    }

    public List<Order> getByCustomerId(long customerId) {
        return orderRepository.getByCustomerId(customerId);
    }

    public OrderHistoryDTO getCustomerOrders(long customerId) {
        Customer customer = customerService.getById(customerId);
        List<CustomerOrderDTO> customerOrders = new ArrayList<>();
        List<Order> orderList = getByCustomerId(customerId);

        for (Order order : orderList) {
            Product product = productService.getById(order.getProductId());
            CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO(
                    order.getId(),
                    product,
                    customerId,
                    order.getPrice()
            );
            customerOrders.add(customerOrderDTO);
        }

        return new OrderHistoryDTO(
                customer.getId(),
                customer.getEmail(),
                customerOrders
        );
    }
}
