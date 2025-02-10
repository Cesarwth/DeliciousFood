package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {
}
