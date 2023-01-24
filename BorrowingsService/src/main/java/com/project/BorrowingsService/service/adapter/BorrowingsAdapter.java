package com.project.BorrowingsService.service.adapter;

import com.project.BorrowingsService.Domain.Borrowing;
import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.Dto.BorrowingsDto;

import java.util.ArrayList;
import java.util.List;

public class BorrowingsAdapter {



    public static Borrowing getBorrowingFromBorrowingDTO(BorrowingDto borrowingDTO){
        return new Borrowing(borrowingDTO.getBorrowingNumber(), borrowingDTO.getDate(),
                borrowingDTO.getCustomerNumber(), borrowingDTO.getCustomerName(), borrowingDTO.getIsbn(),
                borrowingDTO.getBookTitle());
    }
    public static BorrowingDto getBorrowingDTOFromBorrowing(Borrowing borrowing){
        return new BorrowingDto(borrowing.getBorrowingNumber(), borrowing.getDate(),
                borrowing.getCustomerNumber(), borrowing.getCustomerName(),
                borrowing.getIsbn(), borrowing.getBookTitle());
    }

    public static BorrowingsDto getBorrowingsDTOFromBorrowings(List<Borrowing> borrowings){
        List<BorrowingDto> listOfBorrowingDtos = new ArrayList<>();
        for(Borrowing borrowing: borrowings){
            listOfBorrowingDtos.add(new BorrowingDto(borrowing.getBorrowingNumber(), borrowing.getDate(),
                    borrowing.getCustomerNumber(), borrowing.getCustomerName(), borrowing.getIsbn(),
                    borrowing.getBookTitle()));
        }
        BorrowingsDto borrowingsDTO = new BorrowingsDto(listOfBorrowingDtos);
        return borrowingsDTO;
    }
}
