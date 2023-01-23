package com.project.BooksCommandService.Service;


import com.project.BooksCommandService.Service.Dto.BookDto;
import org.springframework.stereotype.Service;


public interface IBookCommandService {

    public BookDto addBook(BookDto bookDto);
    public BookDto updateBook(long isbn, BookDto bookDto);
    public BookDto deleteBook(long isbn);




}
