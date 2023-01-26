package com.project.BorrowingsService.service.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDto {

    private long customerNumber;
    private String name;
    @JsonIgnore
    private AddressDto address;
    @JsonIgnore
    private ContactDto contact;

}
