package com.project.CustomerService.Controller;

import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.Service.CustomerService;
import com.project.CustomerService.adapter.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return  new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerNumber){
        customerService.deleteById(customerNumber);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable long id ){
        return customerService.getCustomerById(id);
    }


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getCustomer(){
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId, CustomerDto customerDto){
        return ResponseEntity.ok().body(customerService.updateCustomer(customerId,customerDto));
    }

}
