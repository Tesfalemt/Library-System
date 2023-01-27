package com.project.CustomerService.Service;

import com.project.CustomerService.adapter.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEvent {

   CustomerDto customerDto;
    String EventStutes;

}
