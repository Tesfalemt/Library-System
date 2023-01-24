package com.project.BooksCommandService.Integration;


import com.project.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, BookDto> kafkaTemplate;

    public void send(String topic, BookDto bookDto){
        kafkaTemplate.send(topic, bookDto);
    }
}
