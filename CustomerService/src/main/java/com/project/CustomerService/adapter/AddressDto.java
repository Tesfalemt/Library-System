package com.project.CustomerService.adapter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String city;
    private String zip;
    private String street;
}
