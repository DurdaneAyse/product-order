package com.example.productorderbackend.service.imp;

import com.example.productorderbackend.dto.CartDto;
import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.entity.Product;
import com.example.productorderbackend.exception.ResourceNotFoundException;
import com.example.productorderbackend.mapper.CartMapper;
import com.example.productorderbackend.mapper.ProductMapper;
import com.example.productorderbackend.repository.CartRepository;
import com.example.productorderbackend.repository.ProductRepository;
import com.example.productorderbackend.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    public CartServiceImpl(CartRepository cartRepository) {

        this.cartRepository = cartRepository;
    }
    @Override
    public CartDto createCart(CartDto cartDto) {
        Cart cart = CartMapper.mapToCart(cartDto);
        Cart savedCart= cartRepository.save(cart);
        return CartMapper.mapToCartDto(savedCart);
    }

    @Override
    public CartDto getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart is not exists with given id: " + cartId));
        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public CartDto updateCart(Long cartId, CartDto updateCart) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart is not exists with given id: " + cartId)
        );
        cart.setCartTotal(updateCart.getCartTotal());
        cart.setCartQuantity(updateCart.getCartQuantity());

        Cart updateCartObj = cartRepository.save(cart);
        return CartMapper.mapToCartDto(updateCartObj);
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart is not exists with given id: " + cartId)
        );
        cartRepository.deleteById(cartId);
    }
}
