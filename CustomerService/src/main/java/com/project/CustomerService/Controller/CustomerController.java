package com.project.CustomerService.Controller;

import com.project.CustomerService.Service.CustomerService;
import com.project.CustomerService.adapter.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerNumber){
        customerService.deleteById(customerNumber);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
