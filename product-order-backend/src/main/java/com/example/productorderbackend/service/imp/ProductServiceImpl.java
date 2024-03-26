package com.example.productorderbackend.service.imp;

import com.example.productorderbackend.dto.OrderDto;
import com.example.productorderbackend.dto.ProductDto;
import com.example.productorderbackend.entity.Order;
import com.example.productorderbackend.entity.Product;
import com.example.productorderbackend.exception.ResourceNotFoundException;
import com.example.productorderbackend.mapper.OrderMapper;
import com.example.productorderbackend.mapper.ProductMapper;
import com.example.productorderbackend.repository.ProductRepository;
import com.example.productorderbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

 private ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct= productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is not exists with given id: " + productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products= productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }


    @Override
    public ProductDto updateProduct(Long productId, ProductDto updateProduct) {

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product is not exists with given id: " + productId)
        );
        product.setProductName(updateProduct.getProductName());
        product.setProductPrice(updateProduct.getProductPrice());
        product.setProductQuantity(updateProduct.getProductQuantity());

        Product updateProductObj = productRepository.save(product);
        return ProductMapper.mapToProductDto(updateProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product is not exists with given id: " + productId)
        );
        productRepository.deleteById(productId);
    }
}
