package com.example.BookStore.Repository;

import com.example.BookStore.Domain.User;
import org.springframework.data.repository.ListCrudRepository;


public interface UserRepository extends ListCrudRepository<User, Long> {


}
