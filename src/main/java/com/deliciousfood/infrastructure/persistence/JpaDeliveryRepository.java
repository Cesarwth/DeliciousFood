package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDeliveryRepository extends JpaRepository<Delivery, Long> {
}
