package com.deliciousfood.application.service;

import com.deliciousfood.application.port.in.DeliveryService;
import com.deliciousfood.application.port.out.DeliveryRepository;
import com.deliciousfood.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    
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
