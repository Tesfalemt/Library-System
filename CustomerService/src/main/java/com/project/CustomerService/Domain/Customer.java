package com.project.CustomerService.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    private Long customerNumber;
    private String name;

    @OneToOne
    private Address address;

    @OneToOne
    private Contact contact;
}
