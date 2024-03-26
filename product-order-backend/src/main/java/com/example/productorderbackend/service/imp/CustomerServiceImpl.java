package com.example.productorderbackend.service.imp;

import com.example.productorderbackend.dto.CustomerDto;
import com.example.productorderbackend.entity.Customer;
import com.example.productorderbackend.exception.ResourceNotFoundException;
import com.example.productorderbackend.mapper.CustomerMapper;
import com.example.productorderbackend.repository.CartRepository;
import com.example.productorderbackend.repository.CustomerRepository;
import com.example.productorderbackend.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer= customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer is not exists with given id: " + customerId));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer is not exists with given id: " + customerId)
        );
        customer.setCustomerName(updateCustomer.getCustomerName());
        customer.setCustomerSurname(updateCustomer.getCustomerSurname());
        customer.setCustomerPhone(updateCustomer.getCustomerPhone());
        customer.setCustomerMail(updateCustomer.getCustomerMail());
        customer.setCustomerAddress(updateCustomer.getCustomerAddress());

        Customer updateCustomerObj = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updateCustomerObj);    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer is not exists with given id: " + customerId)
        );
        customerRepository.deleteById(customerId);
    }
}
