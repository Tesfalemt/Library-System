package com.project.CustomerService;

import com.project.CustomerService.adapter.CustomerDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CustomerList {
    private List<CustomerDto> customerLists;

    public CustomerList(){
        customerLists=new ArrayList<>();
    }
}
