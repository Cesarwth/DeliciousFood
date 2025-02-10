package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
