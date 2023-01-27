package com.project.CustomerService.adapter;

import com.project.CustomerService.Domain.Address;
import com.project.CustomerService.Domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private long customerNumber;
    private String name;
    private AddressDto addressDto;
    private ContactDto contactDto;
}
