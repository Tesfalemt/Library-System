package com.project.BorrowingsService.Controller;

import com.project.BorrowingsService.Domain.Borrowing;
import com.project.BorrowingsService.service.BorrowingsService;
import com.project.BorrowingsService.service.Dto.BorrowingDto;
import com.project.BorrowingsService.service.Dto.BorrowingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = {"/borrowings"})
public class BorrowingsController {

    @Autowired
    BorrowingsService borrowingsService;

    //natu
    @GetMapping("/{borrowingNumber}")
  public ResponseEntity<BorrowingDto> getBorrowing(@PathVariable long borrowingNumber){
       BorrowingDto borrowingDto = borrowingsService.getBorrowing(borrowingNumber);
        return  new ResponseEntity<>(borrowingDto, HttpStatus.OK);
  }
    //luwam
    @GetMapping
    public ResponseEntity<BorrowingsDto> getBorrowings(){
        BorrowingsDto borrowingsDto = borrowingsService.getBorrowings();
    return  new ResponseEntity<>(borrowingsDto, HttpStatus.OK);
}

    //weini
    @PostMapping
    public ResponseEntity<BorrowingDto> addBorrowing(@RequestBody BorrowingDto borrowingDTO){
        BorrowingDto borrowingDto = borrowingsService.addBorrowing(borrowingDTO);
        return new ResponseEntity<>(borrowingDto, HttpStatus.OK);
    }
    //miki
    @PutMapping("/borrowingNumber")
    public ResponseEntity<BorrowingDto> updateBorrowing(@PathVariable long borrowingNumber, @RequestBody BorrowingDto borrowingDto){
        BorrowingDto borrowingDto1 = borrowingsService.updateBorrowing(borrowingNumber, borrowingDto);
        return new ResponseEntity<>(borrowingDto1, HttpStatus.OK);
    }

    //abi
    @DeleteMapping("/{borrowingNumber}")
    public ResponseEntity<BorrowingDto> deleteBurrowing(@PathVariable long borrowingNumber){
        BorrowingDto borrowingDto = borrowingsService.deleteBorrowing(borrowingNumber);
        return new ResponseEntity<>(borrowingDto, HttpStatus.OK);

    }
}
