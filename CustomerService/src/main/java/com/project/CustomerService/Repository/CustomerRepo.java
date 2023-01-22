package com.project.CustomerService.Repository;

import com.project.CustomerService.Domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Long> {
}
