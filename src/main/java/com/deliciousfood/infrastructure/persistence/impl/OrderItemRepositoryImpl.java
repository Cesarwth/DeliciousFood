package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.OrderItemRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.OrderItem;
import com.deliciousfood.infrastructure.persistence.JpaOrderItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    private final JpaOrderItemRepository jpaOrderItemRepositoryRepository;

    public OrderItemRepositoryImpl(JpaOrderItemRepository jpaOrderItemRepositoryRepository) {
        this.jpaOrderItemRepositoryRepository = jpaOrderItemRepositoryRepository;
    }

    @Override
    public List<OrderItem> findAll() {
        return jpaOrderItemRepositoryRepository.findAll();
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return jpaOrderItemRepositoryRepository.save(orderItem);
    }

    @Override
    public OrderItem findById(Long orderItemId) {
        Optional<OrderItem> orderItem = jpaOrderItemRepositoryRepository.findById(orderItemId);
        return orderItem.orElseThrow(() -> new ResourceNotFoundException("Order Item not found"));
    }

    @Override
    public void deleteById(Long orderItemId) {
        jpaOrderItemRepositoryRepository.deleteById(orderItemId);
    }
}
