package com.deliciousfood.application.service;

import com.deliciousfood.application.port.in.OrderItemService;
import com.deliciousfood.application.port.out.OrderItemRepository;
import com.deliciousfood.domain.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
