package com.deliciousfood.application.service;

import com.deliciousfood.application.port.in.DeliveryService;
import com.deliciousfood.application.port.out.DeliveryRepository;
import com.deliciousfood.domain.model.Delivery;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery createDelivey(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId);
    }

    @Override
    public void deleteDelivery(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }
}
