package com.example.productorderbackend.mapper;

import com.example.productorderbackend.dto.CustomerDto;
import com.example.productorderbackend.dto.OrderDto;
import com.example.productorderbackend.entity.Customer;
import com.example.productorderbackend.entity.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getCustomerId(),
                order.getProductId(),
                order.getOrderTotal(),
                order.getProductQuantity()

        );
    }
    public static Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getCustomerId(),
                orderDto.getProductId(),
                orderDto.getOrderTotal(),
                orderDto.getProductQuantity()


        );
    }
}
