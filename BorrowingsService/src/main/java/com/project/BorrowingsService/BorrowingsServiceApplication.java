package com.project.BorrowingsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
@EnableFeignClients
public class BorrowingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingsServiceApplication.class, args);
	}


}
