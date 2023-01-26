package com.project.BorrowingsService.service;


import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.Dto.BorrowingsDto;




public interface BorrowingsService {

    public BorrowingDto getBorrowing(long borrowingNumber);

    public BorrowingsDto getBorrowings();

    public BorrowingDto addBorrowing( long customerNumber,long isbn, BorrowingDto borrowingDto);

    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowingDto borrowingDto); // Miki


    public BorrowingDto deleteBorrowing(long borrowingNumber);



}
