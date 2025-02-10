package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem getOrderItemById(Long orderItemId);

    void deleteOrderItem(Long orderItemId);
}
