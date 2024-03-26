package com.example.productorderbackend.service;

import com.example.productorderbackend.dto.CartDto;
import org.springframework.stereotype.Service;

 public interface CartService {
    CartDto createCart(CartDto cartDto);

    CartDto getCartById(Long cartId);


    CartDto updateCart(Long cartId,CartDto updateCart);

    void deleteCart(Long cartId);
}
