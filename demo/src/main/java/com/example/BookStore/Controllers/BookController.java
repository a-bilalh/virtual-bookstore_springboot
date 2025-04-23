package com.example.BookStore.Controllers;

import lombok.Data;


import java.util.List;


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


/**
 * This controller class uses BookService class to display Books saved in the database
 */
@Data
@Controller
@RequestMapping("/")
public class BookController {


    private BookService bookService;


    /**
     * Constructor that uses BookService instance
     * @param bookService
     */
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    /**
     * Displays fiction books that we have in database
     * @param model 
     * @return fiction books
     */
    @ModelAttribute
    @GetMapping("/fictions/bookDetails")
    public String viewFictions(Model model) {

        List<Book> booksList = bookService.findAllFictions();

        model.addAttribute("booksList", booksList);
        return "bookDetails";
    }


    /**
     * Display non fiction books that we have in database
     * @param model
     * @return non fiction books
     */
    @ModelAttribute
    @GetMapping("/nonfictions/bookDetails")
    public String viewNonFictions(Model model) {

        List<Book> booksList = bookService.findAllNonFictions();

        model.addAttribute("booksList", booksList);

        return "bookDetails";
    }


    //This method is not used now! 
/*
    @ModelAttribute
    public void addToModel(Model model) {

    

        List<Book> booksList = bookService.findAllBooks();
        

        model.addAttribute("booksList", booksList);
    
    }
        */

}
