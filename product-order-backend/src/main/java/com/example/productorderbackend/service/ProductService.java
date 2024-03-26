package com.example.productorderbackend.service;

import com.example.productorderbackend.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct(Long productId,ProductDto updateProduct);

    void deleteProduct(Long productId);
}



