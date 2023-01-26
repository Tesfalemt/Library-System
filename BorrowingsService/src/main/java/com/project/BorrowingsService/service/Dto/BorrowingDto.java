package com.project.BorrowingsService.service.Dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BorrowingDto {

    private long borrowingNumber;
    private String date;
//    private long customerNumber;
//    private String customerName;
//    private long isbn;
//    private String bookTitle;
    private CustomerDto customerDto;
    private BookDto bookDto;
}
