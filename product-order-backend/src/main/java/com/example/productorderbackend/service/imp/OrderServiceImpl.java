package com.example.productorderbackend.service.imp;

import com.example.productorderbackend.dto.OrderDto;
import com.example.productorderbackend.entity.Order;
import com.example.productorderbackend.exception.ResourceNotFoundException;
import com.example.productorderbackend.mapper.OrderMapper;
import com.example.productorderbackend.repository.CustomerRepository;
import com.example.productorderbackend.repository.OrderRepository;
import com.example.productorderbackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder= orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order is not exists with given id: " + orderId));
        return OrderMapper.mapToOrderDto(order);    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<Order> orders= orderRepository.findAll();

        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto updateOrder) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id: " + orderId)
        );
        order.setCustomerId(updateOrder.getCustomerId());
        order.setProductId(updateOrder.getProductId());
        order.setOrderTotal(updateOrder.getOrderTotal());
        order.setProductQuantity(updateOrder.getProductQuantity());

        Order updateOrderObj = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(updateOrderObj);    }
}
