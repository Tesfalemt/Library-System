package com.project.BooksCommandService.Service.adapter;

import com.project.BooksCommandService.Domain.Book;
import com.project.BooksCommandService.Service.Dto.BookDto;

public class BookAdapter {
    public static Book getBookFromBookDto(BookDto bookDto){
        return new Book(bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription(),
                bookDto.getAuthor());
    }

    public static BookDto getBookDtoFromBook(Book book){
        return new BookDto(book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthor());
    }

}
