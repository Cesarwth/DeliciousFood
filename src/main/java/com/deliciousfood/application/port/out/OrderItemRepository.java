package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    List<OrderItem> findAll();

    OrderItem save(OrderItem orderItem);

    OrderItem findById(Long orderItemId);

    void deleteById(Long orderItemId);
}
