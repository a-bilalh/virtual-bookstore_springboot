package com.example.BookStore.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Domain.Book;


@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {
    
    @NativeQuery("select * from book where lower(genre)='fiction'")
    List<Book> findAllFictions();

    @NativeQuery("select * from book where lower(genre)='non fiction'")
    List<Book> findAllNonFictions();

}