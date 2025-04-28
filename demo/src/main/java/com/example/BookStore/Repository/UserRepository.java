package com.example.BookStore.Repository;

import com.example.BookStore.Domain.Users;
import org.springframework.data.repository.ListCrudRepository;


public interface UserRepository extends ListCrudRepository<Users, Long> {

    public Users findByUsername(String username);
}
