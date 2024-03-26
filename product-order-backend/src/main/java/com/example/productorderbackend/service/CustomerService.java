package com.example.productorderbackend.service;

import com.example.productorderbackend.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long customerId);


    CustomerDto updateCustomer(Long customerId,CustomerDto updateCustomer);

    void deleteCustomer(Long customerId);
}
