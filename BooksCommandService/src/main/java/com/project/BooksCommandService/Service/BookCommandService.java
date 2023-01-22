package com.project.BooksCommandService.Service;

import com.project.BooksCommandService.Repository.BookCommandRepo;
import com.project.BooksCommandService.Domain.Book;
import com.project.BooksCommandService.Service.Dto.BookAdapter;
import com.project.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookCommandService implements IBookCommandService{

    @Autowired
    private BookCommandRepo bookCommandRepo;

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = BookAdapter.getBookFromBookDto(bookDto);
        bookCommandRepo.save(book);
        //kafkaSender.send("addbooktopic",bookDTO);
        return bookDto;
    }

    @Override
    public BookDto updateBook(long isbn, BookDto bookDto) {
        Optional<Book> optionalBook = bookCommandRepo.findById(isbn);
        if (optionalBook.isPresent()){
            Book book = BookAdapter.getBookFromBookDto(bookDto);
            bookCommandRepo.save(book);
         //   kafkaSender.send("updatebooktopic",bookDTO);
        }
        return bookDto;
    }

    @Override
    public BookDto deleteBook(long isbn) {
        Book book = bookCommandRepo.findById(isbn).get();
        BookDto bookDTO = BookAdapter.getBookDtoFromBook(book);
        bookCommandRepo.deleteById(isbn);
        //kafkaSender.send("deletebooktopic",bookDTO);
        return bookDTO;
    }
}
