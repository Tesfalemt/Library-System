package com.project.BorrowingsService.integration;



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
    public void receive(@Payload BookDto bookDto) {
        System.out.println("received message=" + bookDto.toString());
        List<Borrowing> borrowings = borrowingDAO.findBorrowingsByIsbn(bookDto.getIsbn());
        for (Borrowing borrowing : borrowings) {
            borrowing.setIsbn(bookDto.getIsbn());
            borrowing.setBookTitle(bookDto.getTitle());
            borrowingDAO.save(borrowing);
        }
    }
}