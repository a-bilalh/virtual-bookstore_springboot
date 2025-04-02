package com.example.BookStore.Domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.ArrayList;



@Data
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private BigDecimal price;

    private String genre;

    private List<String> detailedGenres;


    protected Book() {}


    public Book(String title, String author, BigDecimal price, String genre) {
        
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.detailedGenres = new ArrayList<>();
    }


    public Book(String title, String author, BigDecimal price, String genre, ArrayList<String> list) {
        
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.detailedGenres = list;
    }


}
