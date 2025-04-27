package com.example.BookStore.Domain;


import java.util.Collection;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Entity
@Data
@NoArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    public Users(String username, String password, String fullName, String street
                , String city, String state, String zipCode, String phoneNumber) {

                    this.username = username;
                    this.password = password;
                    this.fullName = fullName;
                    this.street = street;
                    this.city = city;
                    this.state = state;
                    this.zipCode = zipCode;
                    this.phoneNumber = phoneNumber;
                }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Users createUser(PasswordEncoder passwordEncoder) {
        
        return new Users(username, passwordEncoder.encode(password), fullName, street, 
                    city, state, zipCode, phoneNumber);
        
    }


}
    
