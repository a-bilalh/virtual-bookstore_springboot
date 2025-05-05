package com.example.BookStore.Domain;

import java.util.HashMap;



public class Cart {
    

    private HashMap<String, Integer> myCart;


    public Cart() {
        myCart = new HashMap<>();
    }


    public HashMap<String, Integer> getMyCart() {
        return myCart;
    }


    public void addItem(String item) {

        if (myCart.containsKey(item)) {
            myCart.put(item, myCart.get(item) + 1);
        } else {
            myCart.put(item, 1);
        }
    }

    
    public void decreaseItemValue(String item) {

        if (myCart.containsKey(item)) {

            if (myCart.get(item) == 1) {
                myCart.remove(item);
            } else {
                myCart.put(item, myCart.get(item) - 1);
            }
        } 
    }



}
