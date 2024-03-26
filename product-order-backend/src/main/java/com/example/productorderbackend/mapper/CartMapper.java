package com.example.productorderbackend.mapper;

import com.example.productorderbackend.dto.CartDto;
import com.example.productorderbackend.entity.Cart;

public class CartMapper {
    public static CartDto mapToCartDto(Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getCartQuantity(),
                cart.getCartTotal()
                );
    }
    public static Cart mapToCart(CartDto cartDto){
        return new Cart(
                cartDto.getId(),
                cartDto.getCartTotal(),
                cartDto.getCartQuantity()

        );
    }
}
