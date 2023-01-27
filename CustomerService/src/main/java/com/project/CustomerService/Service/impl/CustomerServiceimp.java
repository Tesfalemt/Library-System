package com.project.CustomerService.Service.impl;

import com.project.CustomerService.CustomerIntegration.Sender;
import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.Repository.CustomerRepo;
import com.project.CustomerService.Service.CustomerEvent;
import com.project.CustomerService.Service.CustomerService;
import com.project.CustomerService.adapter.CustomerAdaptor;
import com.project.CustomerService.adapter.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceimp implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    Sender sender;


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


        sender.send(new CustomerEvent(CustomerAdaptor.getCustomerDtoFromCustomer(customer),"Delete"));
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer = customerRepo.findById(id).get();
        return customer;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        //get all customers from DB
        return customerRepo.findAll().stream()
                .map(n->CustomerAdaptor.getCustomerDtoFromCustomer(n))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto customerDto) {
        //get the customer from the DB with the given ID
        var customer =customerRepo.findById(customerId).get();

        if(customer!=null) {
            customer.setName(customerDto.getName());
            customer.getAddress().setCity(customerDto.getAddressDto().getCity());
            customer.getAddress().setZip(customerDto.getAddressDto().getZip());
            customer.getAddress().setStreet(customerDto.getAddressDto().getStreet());
            customer.getContact().setEmail(customerDto.getContactDto().getEmail());
            customer.getContact().setPhone(customerDto.getContactDto().getPhone());
            //save the updated customer to the DB
            customerRepo.save(customer);
            //send the message to the borrowing after updating
           sender.send(new CustomerEvent(CustomerAdaptor.getCustomerDtoFromCustomer(customer), "Update"));

        }else throw new NullPointerException("Customer didn't find in the DB");
        return CustomerAdaptor.getCustomerDtoFromCustomer(customer);
    }
}
