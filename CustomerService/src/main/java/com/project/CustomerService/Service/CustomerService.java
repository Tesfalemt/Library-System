package com.project.CustomerService.Service;


import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.adapter.CustomerDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    void deleteById(Long customerNumber);
    public Customer getCustomerById(long id);

}
