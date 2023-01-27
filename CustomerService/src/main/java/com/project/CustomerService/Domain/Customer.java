package com.project.CustomerService.Domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerNumber;
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Contact contact;
}
