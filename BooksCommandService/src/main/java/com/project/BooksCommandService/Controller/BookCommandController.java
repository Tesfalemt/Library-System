package com.project.BooksCommandService.Controller;

import com.project.BooksCommandService.Service.Dto.BookDto;
import com.project.BooksCommandService.Service.IBookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookCommandController {

    @Autowired
    private IBookCommandService iBookCommandService;

   @PostMapping("/add")
   public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
       iBookCommandService.addBook(bookDto);
       return new ResponseEntity<>( bookDto, HttpStatus.OK);
    }
    @PutMapping("/update/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable long isbn, @RequestBody BookDto bookDto){
       iBookCommandService.updateBook(isbn,bookDto);
        return new ResponseEntity<>( bookDto, HttpStatus.OK);
    }

    //aaaannnn
    //just checking new
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@PathVariable long isbn){
       BookDto bookDto = iBookCommandService.deleteBook(isbn);
       return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

}
