package com.project.BorrowingsService.service.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AddressDto {
    @JsonIgnore
    private String customerNumber;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private AddressDto address;
    @JsonIgnore
    private ContactDto contact;
}
