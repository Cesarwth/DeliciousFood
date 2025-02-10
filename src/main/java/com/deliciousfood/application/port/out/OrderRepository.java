package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    Order save(Order order);

    Order findById(Long orderId);

    void deleteById(Long orderId);
}
