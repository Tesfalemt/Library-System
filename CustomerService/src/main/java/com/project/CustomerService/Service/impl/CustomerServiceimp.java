package com.project.CustomerService.Service.impl;

import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.Repository.CustomerRepo;
import com.project.CustomerService.Service.CustomerService;
import com.project.CustomerService.adapter.CustomerAdaptor;
import com.project.CustomerService.adapter.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceimp implements CustomerService {
@Autowired
    CustomerRepo customerRepo;
    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer= CustomerAdaptor.getCustomerFromCustomerDto(customerDto);
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(Long customerNumber) {
        var customer=customerRepo.findById(customerNumber).orElseThrow();
        if (customer!=null){
            customerRepo.deleteById(customerNumber);
        }
        else System.out.println("customer is not found");

    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer = customerRepo.findById(id).get();
        return customer;
    }
}
