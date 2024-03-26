package com.example.productorderbackend.mapper;

import com.example.productorderbackend.dto.OrderDto;
import com.example.productorderbackend.dto.ProductDto;
import com.example.productorderbackend.entity.Order;
import com.example.productorderbackend.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity()

        );
    }
    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getProductQuantity()


        );
    }
}
