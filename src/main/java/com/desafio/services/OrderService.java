package com.desafio.services;

import com.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total (Order order) {

        double finalDiscount = (order.getDiscount()/100.00)*order.getBasic();
        return order.getBasic() - finalDiscount + shippingService.shipment(order);

    }
}
