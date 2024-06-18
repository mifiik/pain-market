package com.dobraccon.pain_market.order;


import com.dobraccon.pain_market.customer.Customer;
import com.dobraccon.pain_market.customer.CustomerService;
import com.dobraccon.pain_market.order.details.OrderWithDetails;
import com.dobraccon.pain_market.product.Product;
import com.dobraccon.pain_market.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public OrderWithDetails getByOrderId(long orderId) {
        Order order = orderRepository.getById(orderId);
        Product orderProduct = productService.getById(order.getProductId());
        Customer orderCustomer = customerService.getById(order.getClientId());

        return new OrderWithDetails(
                order.getId(),
                orderProduct,
                orderCustomer);
    }
}
