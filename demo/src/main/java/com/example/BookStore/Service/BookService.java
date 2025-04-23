package com.example.BookStore.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.Domain.Book;
import com.example.BookStore.Repository.BookRepository;


@Service
@lombok.Data
public class BookService {



    private BookRepository repository;



    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    

    public List<Book> findAllBooks() {
        return this.repository.findAll();
    }

    public List<Book> findAllFictions() {
        return this.repository.findAllFictions();
    }

    public List<Book> findAllNonFictions() {
        return this.repository.findAllNonFictions();
    }


    public void saveBook(Book book) {
        this.repository.save(book);
    }

    public void saveAllBooks(List<Book> books) {
        this.repository.saveAll(books);
    }

}
