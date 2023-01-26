package com.project.BooksQueryService.BookQueryIntegration;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReviewReceiver {

    //you can write your code after receiving the message.
    @KafkaListener(topics = "createReview")
    public void receive(@Payload String reviewDtoString,
                        @Headers MessageHeaders headers) {


        System.out.println("received message="+ reviewDtoString);
    }

}