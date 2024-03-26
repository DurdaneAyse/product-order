package com.example.productorderbackend.controller;

import com.example.productorderbackend.dto.OrderDto;
import com.example.productorderbackend.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order_table")
public class OrderController {
private final OrderService orderService;

    //Build add Order REST API
    @PostMapping

    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto savedOrder= orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    //Build Get Order REST API
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long orderId){
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    // Build Get All Order REST API
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder(){
        List<OrderDto> orders =orderService.getAllOrder();
        return ResponseEntity.ok(orders);
    }

    //Build Upgrade Order REST API
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderId,
                                                @RequestBody OrderDto updateOrder){
        OrderDto orderDto=orderService.updateOrder(orderId,updateOrder);
        return ResponseEntity.ok(orderDto);
    }


}
