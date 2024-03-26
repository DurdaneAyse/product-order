package com.example.productorderbackend.repository;

import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
