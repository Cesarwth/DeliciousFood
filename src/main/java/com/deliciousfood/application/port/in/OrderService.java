package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    void deleteOrder(Long orderId);
}
