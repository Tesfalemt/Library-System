package com.project.CustomerService.Service;


import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.adapter.CustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    void deleteById(Long customerNumber);
    public Customer getCustomerById(long id);

    public List<CustomerDto> getCustomers();

    public CustomerDto updateCustomer(Long customerId,CustomerDto customerDto);

}
