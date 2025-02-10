package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.Delivery;

import java.util.List;

public interface DeliveryRepository {
    List<Delivery> findAll();

    Delivery save(Delivery delivery);

    Delivery findById(Long deliveryId);

    void deleteById(Long deliveryId);
}
