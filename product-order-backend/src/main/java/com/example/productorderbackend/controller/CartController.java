package com.example.productorderbackend.controller;

import com.example.productorderbackend.dto.CartDto;
import com.example.productorderbackend.dto.ProductDto;
import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.service.CartService;
import com.example.productorderbackend.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    //Build add Cart REST API
    @PostMapping

    public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto){
        CartDto savedCart= cartService.createCart(cartDto);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    //Build Get Cart REST API
    @GetMapping("{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") Long cartId){
        CartDto cartDto = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartDto);
    }


    //Build Upgrade Cart REST API
    @PutMapping("{id}")
    public ResponseEntity<CartDto> updateCart(@PathVariable("id") Long cartId,
                                                    @RequestBody CartDto updateCart){
        CartDto cartDto=cartService.updateCart(cartId,updateCart);
        return ResponseEntity.ok(cartDto);
    }

    // Build Delete Cart REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Long cartId){
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Cart deleted succesfully!..");
    }
}
