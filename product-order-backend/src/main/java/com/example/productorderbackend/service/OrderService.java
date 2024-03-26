package com.example.productorderbackend.service;

import com.example.productorderbackend.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long orderId);

    List<OrderDto> getAllOrder();

    OrderDto updateOrder(Long orderId, OrderDto updateOrder);

}
