package com.project.CustomerService.adapter;

import com.project.CustomerService.Domain.Customer;

public class CustomerAdaptor {
    public static Customer getCustomerFromCustomerDto(CustomerDto customerDto){
        return new Customer(customerDto.getCustomerNumber(),
                customerDto.getName(), customerDto.getAddress(),customerDto.getContact());
    }
    public static CustomerDto getCustomerDtoFromCustomer(Customer customer){
        return  new CustomerDto(customer.getCustomerNumber(),
                customer.getName(), customer.getAddress(),customer.getContact());
    }

}
