package com.example.BookStore.Domain;

import java.util.HashMap;



public class Cart {
    

    private HashMap<Book, Integer> myCart;


    public Cart() {
        myCart = new HashMap<>();
    }


    public HashMap<Book, Integer> getMyCart() {
        return myCart;
    }


    public void addItem(Book book) {

        if (myCart.containsKey(book)) {
            myCart.put(book, myCart.get(book) + 1);
        } else {
            myCart.put(book, 1);
        }
    }

    
    public void decreaseItemValue(Book book) {

        if (myCart.containsKey(book)) {

            if (myCart.get(book) == 1) {
                myCart.remove(book);
            } else {
                myCart.put(book, myCart.get(book) - 1);
            }
        } 
    }


    public void clearCart() {
        myCart.clear();
    }



}
