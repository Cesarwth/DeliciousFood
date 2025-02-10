package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.DeliveryRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.Delivery;
import com.deliciousfood.infrastructure.persistence.JpaDeliveryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository {
    private final JpaDeliveryRepository jpaDeliveryRepository;

    public DeliveryRepositoryImpl(JpaDeliveryRepository jpaDeliveryRepository) {
        this.jpaDeliveryRepository = jpaDeliveryRepository;
    }

    @Override
    public List<Delivery> findAll() {
        return jpaDeliveryRepository.findAll();
    }

    @Override
    public Delivery save(Delivery delivery) {
        return jpaDeliveryRepository.save(delivery);
    }

    @Override
    public Delivery findById(Long deliveryId) {
        Optional<Delivery> delivery = jpaDeliveryRepository.findById(deliveryId);
        return delivery.orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));
    }

    @Override
    public void deleteById(Long deliveryId) {
        jpaDeliveryRepository.deleteById(deliveryId);
    }
}
