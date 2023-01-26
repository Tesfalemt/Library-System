package com.project.BorrowingsService.integration;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.BorrowingsService.Domain.Borrowing;
import com.project.BorrowingsService.Repository.BorrowingDAO;
import com.project.BorrowingsService.service.BorrowingsService;
import com.project.BorrowingsService.service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListener {
    @Autowired
    BorrowingDAO borrowingDAO;
    @Autowired
    BorrowingsService borrowingsService;

    @KafkaListener(topics = {"update-book-topic"}, groupId = "gid")
    public void receive(@Payload String bookDtoString) {
        ObjectMapper objectMapper = new ObjectMapper();
        BookDto bookDto;
        try {
            bookDto = objectMapper.readValue(bookDtoString , BookDto.class);
            List<Borrowing> borrowings = borrowingDAO.findBorrowingsByIsbn(bookDto.getIsbn());
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getIsbn() == bookDto.getIsbn()){
                borrowing.setIsbn(bookDto.getIsbn());
                borrowing.setBookTitle(bookDto.getTitle());
                borrowingDAO.save(borrowing);
            }
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}