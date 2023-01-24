package com.project.BooksCommandService.Service.Impl;

import com.project.BooksCommandService.Integration.KafkaSender;
import com.project.BooksCommandService.Repository.BookCommandRepo;
import com.project.BooksCommandService.Domain.Book;
import com.project.BooksCommandService.Service.IBookCommandService;
import com.project.BooksCommandService.Service.adapter.BookAdapter;
import com.project.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookCommandServiceImp implements IBookCommandService {

    @Autowired
    private BookCommandRepo bookCommandRepo;
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = BookAdapter.getBookFromBookDto(bookDto);
        bookCommandRepo.save(book);
        kafkaSender.send("add-book-topic",bookDto);
        return bookDto;
    }

    @Override
    public BookDto updateBook(long isbn, BookDto bookDto) {
        Optional<Book> optionalBook = bookCommandRepo.findById(isbn);
        if (optionalBook.isPresent()){
            Book book = BookAdapter.getBookFromBookDto(bookDto);
            bookCommandRepo.save(book);
            kafkaSender.send("update-book-topic",bookDto);
        }
        return bookDto;
    }

    @Override
    public BookDto deleteBook(long isbn) {
        Book book = bookCommandRepo.findById(isbn).get();
        BookDto bookDTO = BookAdapter.getBookDtoFromBook(book);
        bookCommandRepo.deleteById(isbn);
        kafkaSender.send("delete-book-topic",bookDTO);
        return bookDTO;
    }
}
