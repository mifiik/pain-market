package com.dobraccon.pain_market.delivery;

import com.dobraccon.pain_market.customer.Customer;
import com.dobraccon.pain_market.customer.CustomerService;
import com.dobraccon.pain_market.delivery.deliveryDto.DeliveryDTO;
import com.dobraccon.pain_market.order.Order;
import com.dobraccon.pain_market.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final OrderService orderService;
    private final CustomerService customerService;


    public void create(Delivery delivery) {
        deliveryRepository.create(delivery);
    }

    public Delivery getById(long id) {
        return deliveryRepository.getById(id);
    }

    public void deleteByDeliveryId(long deliveryId) {
        deliveryRepository.deleteByDeliveryId(deliveryId);
    }

    public void deleteByAddress(String deliveryAddress) {
        deliveryRepository.deleteByAddress(deliveryAddress);
    }

    public void deleteByOrderIdAndCustomerId(long orderId, long customerId) {
        deliveryRepository.deleteByOrderIdAndCustomerId(orderId, customerId);
    }

    public List<DeliveryDTO> getDeliveryDtoById(long statusId) {
        List<DeliveryDTO> deliveryDTOsList = new ArrayList<>();
        List<Delivery> deliveryList = getByStatusId(statusId);
        DeliveryStatus deliveryStatus = DeliveryStatus.getById(statusId);

        for (Delivery delivery : deliveryList) {
            Order order = orderService.getById(delivery.getOrderId());
            Customer customer = customerService.getById(delivery.getCustomerId());

            DeliveryDTO deliveryDTO = new DeliveryDTO(
                    delivery.getId(),
                    order,
                    customer,
                    deliveryStatus,
                    delivery.getAddress()
            );

            deliveryDTOsList.add(deliveryDTO);
        }

        return deliveryDTOsList;
    }

    private List<Delivery> getByStatusId(long statusId) {
        return deliveryRepository.getByStatusId(statusId);
    }
}
