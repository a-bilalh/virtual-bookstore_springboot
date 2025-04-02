package com.example.BookStore.Controllers;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Long;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.BookStore.Domain.Book;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Data
@Controller
@RequestMapping("/bookDetails")
public class BookController {



    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping
    public String bookView() {
        return "bookDetails";
    }


    @ModelAttribute
    public void addToModel(Model model) {

    
        // Some Hard Coded Books, which will be changed later so we can get it from the database

        Book b1 = new Book("war and peace", "Leo Tolstoy", new BigDecimal(15.0), "fiction");
        Book b2 = new Book("To Kill a Mockiingbird", "Harper Lee", new BigDecimal(10.0), "fiction");


        List<Book> booksList = bookService.findAllBooks();
        

        model.addAttribute("booksList", booksList);
    
    }

}
