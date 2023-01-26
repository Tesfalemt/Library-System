package com.project.BorrowingsService.service.Impl;


import com.project.BorrowingsService.Domain.Borrowing;
import com.project.BorrowingsService.Repository.BorrowingDAO;
import com.project.BorrowingsService.service.BorrowingsService;
import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.adapter.BorrowingsAdapter;

import com.project.BorrowingsService.service.Dto.BorrowingsDto;
import com.project.BorrowingsService.service.Dto.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class BorrowingsServiceImpl implements BorrowingsService {

    @Autowired
   private  BorrowingDAO borrowingDAO;

    @Override
    public BorrowingDto getBorrowing(long borrowingNumber) {
     Optional<Borrowing>  borrowing = borrowingDAO.findById(borrowingNumber);
     if (borrowing.isPresent()){
         BorrowingDto borrowingDto = BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing.get());
         return borrowingDto;
     }
     return new CustomMessage("Borrowing with " + borrowingNumber + " not available");
    }

    @Override
    public BorrowingsDto getBorrowings() {
      //  List<Borrowing> borrowings = borrowingDAO.findAll();
        BorrowingsDto borrowingDtos  =  BorrowingsAdapter.getBorrowingsDTOFromBorrowings(borrowingDAO.findAll());
        return borrowingDtos;
    }

    @Override
    public BorrowingDto addBorrowing( long customerNumber, long isbn) {
       BorrowingDto borrowingDto =
        Borrowing borrowing = BorrowingsAdapter.getBorrowingFromBorrowingDTO(borrowingDto);
        borrowingDAO.save(borrowing);
        return borrowingDto;
    }

    @Override
    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowingDto borrowingDto) {
        Optional<Borrowing> borrowing = borrowingDAO.findById(borrowingNumber);
        if (borrowing.isPresent()){
           Borrowing borrowing1 = borrowing.get();
           borrowing1.setBorrowingNumber(borrowingDto.getBorrowingNumber());
           borrowing1.setDate(borrowingDto.getDate());
           borrowing1.setCustomerNumber(borrowingDto.getCustomerNumber());
           borrowing1.setCustomerName(borrowingDto.getCustomerName());
           borrowing1.setIsbn(borrowingDto.getIsbn());
           borrowing1.setBookTitle(borrowingDto.getBookTitle());
           borrowingDAO.save(borrowing1);
           return BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing1);
        }


        return new CustomMessage("Borrowing with " + borrowingNumber + " Is not available for update");
    }

    @Override
    public BorrowingDto deleteBorrowing(long borrowingNumber) {
            Optional<Borrowing> borrowing = borrowingDAO.findById(borrowingNumber);
            if (borrowing.isPresent()) {
                BorrowingDto borrowingDTO = BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing.get());
                borrowingDAO.deleteById(borrowingNumber);
                return borrowingDTO;
            }
        return new CustomMessage("Borrowing with " + borrowingNumber + " Is not available for deletion");

        }
}
