package com.example.BookStore;


import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.Domain.Book;
import com.example.BookStore.Repository.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

@Bean
CommandLineRunner runner(BookRepository repository) {


    return args -> {

		
        Book b1 = new Book("war and peace", "Leo Tolstoy", new BigDecimal(15.0), "fiction");
        Book b2 = new Book("To Kill a Mockiingbird", "Harper Lee", new BigDecimal(10.0), "fiction");

      

      repository.save(b1);
	  repository.save(b2);
    };
  }



}
