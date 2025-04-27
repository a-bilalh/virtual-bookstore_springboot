package com.example.BookStore.Controllers;

import com.example.BookStore.Domain.Users;
import com.example.BookStore.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepo;


    public RegistrationController(PasswordEncoder passwordEncoder, UserRepository userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;

    }


    /**
     * Display registration form 
     * @param model 
     * @return registration page 
     */
    @GetMapping("/registration")
    public String registrationForm(Model model) {
        
        model.addAttribute("user", new Users());
        return "registration";
    }


    /**
     * Save user information in the user repository 
     * @param user
     * @return login page 
     */
    @PostMapping("/register")
    public String register( @ModelAttribute Users user) {

        userRepo.save(user.createUser(passwordEncoder));
        return "redirect:/login";

    }

}
