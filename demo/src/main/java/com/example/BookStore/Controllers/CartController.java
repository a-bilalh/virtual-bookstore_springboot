package com.example.BookStore.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.BookStore.Domain.Book;
import com.example.BookStore.Domain.Cart;
import com.example.BookStore.Repository.BookRepository;

import jakarta.servlet.http.HttpSession;



@Controller
public class CartController {
    

    private BookRepository bookRepository;

    public CartController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/myCart")
    @ModelAttribute
    public String viewCart(HttpSession httpSession, Model model) {

        Cart cart = (Cart) httpSession.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            httpSession.setAttribute("cart", cart);
        }
        model.addAttribute("cart", cart);
        System.out.println(cart.getMyCart());

        return "/myCart";
    }


    @PostMapping("/addToCart")
    public String addItem(HttpSession httpSession, @RequestParam("bookId") Long id) {

        Cart cart = (Cart) httpSession.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            httpSession.setAttribute("cart", cart);

        } 
        
        Book theBook = bookRepository.findById(id).orElse(null);
        cart.addItem(theBook);
        System.out.println(theBook);
        System.out.println( "Bookid is: " + id );
      
        return "redirect:/fictions/bookDetails";
    }




}
