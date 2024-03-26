package com.example.productorderbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Integer customerId;
    private Integer productId;
    private Double orderTotal;
    private Integer productQuantity;
}
