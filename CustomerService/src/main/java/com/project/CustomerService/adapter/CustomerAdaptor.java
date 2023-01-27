package com.project.CustomerService.adapter;

import com.project.CustomerService.Domain.Address;
import com.project.CustomerService.Domain.Contact;
import com.project.CustomerService.Domain.Customer;

public class CustomerAdaptor {
    public static Customer getCustomerFromCustomerDto(CustomerDto customerDto){
        return new Customer(customerDto.getCustomerNumber(),
                customerDto.getName(), new Address(customerDto.getAddressDto().getCity(),
                customerDto.getAddressDto().getZip(),customerDto.getAddressDto().getStreet()),
                new Contact(customerDto.getContactDto().getPhone(),customerDto.getContactDto().getEmail()));
    }
    public static CustomerDto getCustomerDtoFromCustomer(Customer customer){
        return  new CustomerDto(customer.getCustomerNumber(),
                customer.getName(), new AddressDto(customer.getAddress().getCity(),
                customer.getAddress().getZip(),customer.getAddress().getStreet()),
                new ContactDto(customer.getContact().getPhone(),customer.getContact().getEmail()));
    }

}
