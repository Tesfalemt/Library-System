package com.project.BooksCommandService.Integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, BookDto bookDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        String bookDtoString ;
        try{
            bookDtoString = objectMapper.writeValueAsString(bookDTO);
            kafkaTemplate.send(topic, bookDtoString);
        }catch (Exception e){
            throw new RuntimeException("exception occured during sending with kafka object as a string");
        }

    }

}
