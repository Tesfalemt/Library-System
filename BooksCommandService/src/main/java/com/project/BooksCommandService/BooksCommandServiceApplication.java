package com.project.BooksCommandService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BooksCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksCommandServiceApplication.class, args);
	}

}
