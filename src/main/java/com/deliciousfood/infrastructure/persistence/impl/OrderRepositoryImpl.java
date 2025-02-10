package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.OrderRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.Order;
import com.deliciousfood.infrastructure.persistence.JpaOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return jpaOrderRepository.save(order);
    }

    @Override
    public Order findById(Long orderId) {
        Optional<Order> order = jpaOrderRepository.findById(orderId);
        return order.orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public void deleteById(Long orderId) {
        jpaOrderRepository.deleteById(orderId);
    }
}
