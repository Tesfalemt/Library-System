package com.project.BorrowingsService.service.adapter;


import com.project.BorrowingsService.Domain.Borrowing;
import com.project.BorrowingsService.service.Dto.BookDto;
import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.Dto.BorrowingsDto;
import com.project.BorrowingsService.service.Dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class BorrowingsAdapter {



    public static Borrowing createBorrowing(CustomerDto customerDto , BookDto bookDto, BorrowingDto borrowingDTO){
        return new Borrowing(borrowingDTO.getBorrowingNumber(), borrowingDTO.getDate(),
                customerDto , bookDto);
    }


    public static BorrowingDto getBorrowingDTOFromBorrowing(Borrowing borrowing){
        return new BorrowingDto(borrowing.getBorrowingNumber(), borrowing.getDate(),
                borrowing.getCustomer(), borrowing.getBook());
    }

    public static BorrowingsDto getBorrowingsDTOFromBorrowings(List<Borrowing> borrowings){
        List<BorrowingDto> listOfBorrowingDtos = new ArrayList<>();
        for(Borrowing borrowing: borrowings){
            listOfBorrowingDtos.add(new BorrowingDto(borrowing.getBorrowingNumber(), borrowing.getDate(),
                    borrowing.getCustomer(), borrowing.getBook()));
        }
        BorrowingsDto borrowingsDTO = new BorrowingsDto(listOfBorrowingDtos);
        return borrowingsDTO;
    }
}
