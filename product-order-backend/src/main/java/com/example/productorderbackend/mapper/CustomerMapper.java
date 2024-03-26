package com.example.productorderbackend.mapper;

import com.example.productorderbackend.dto.CartDto;
import com.example.productorderbackend.dto.CustomerDto;
import com.example.productorderbackend.entity.Cart;
import com.example.productorderbackend.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCustomerSurname(),
                customer.getCustomerPhone(),
                customer.getCustomerMail(),
                customer.getCustomerAddress()
        );
    }
    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerSurname(),
                customerDto.getCustomerPhone(),
                customerDto.getCustomerMail(),
                customerDto.getCustomerAddress()


        );
    }

}
