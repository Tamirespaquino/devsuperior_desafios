package com.desafio.services;

import com.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment (Order order) {

        if (order.getBasic() < 100.00) {
            return order.setDiscount(20.00);
        } else if (order.getBasic() > 200.00) {
            return order.setDiscount(0.0);
        } else {
            return order.setDiscount(12.00);
        }
    }
}
