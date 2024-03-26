package com.example.productorderbackend.repository;

import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
