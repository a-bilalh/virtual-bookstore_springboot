package com.example.BookStore.Repository;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Domain.Book;


@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {
    

}