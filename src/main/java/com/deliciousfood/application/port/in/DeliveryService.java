package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> getAllDeliveries();

    Delivery createDelivey(Delivery delivery);

    Delivery getDeliveryById(Long deliveryId);

    void deleteDelivery(Long deliveryId);
}
