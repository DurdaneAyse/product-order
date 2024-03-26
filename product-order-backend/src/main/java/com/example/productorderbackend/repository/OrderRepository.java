package com.example.productorderbackend.repository;

import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
