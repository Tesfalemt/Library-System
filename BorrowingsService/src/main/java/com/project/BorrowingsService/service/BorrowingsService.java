package com.project.BorrowingsService.service;


import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.Dto.BorrowingsDto;

import java.util.List;

import java.util.List;


public interface BorrowingsService {

    public BorrowingDto getBorrowing(long borrowingNumber); // Natu

    public BorrowingsDto getBorrowings(); // Luwam

    public BorrowingDto addBorrowing(long isbn, long customerNumber);  //Weini

    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowingDto borrowingDto); // Miki


    public BorrowingDto deleteBorrowing(long borrowingNumber); // Abi



}
