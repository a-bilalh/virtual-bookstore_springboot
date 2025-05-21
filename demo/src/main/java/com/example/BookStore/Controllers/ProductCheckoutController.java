package com.example.BookStore.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.Domain.ProductRequest;
import com.example.BookStore.Domain.StripeResponse;
import com.example.BookStore.Service.StripeService;


@RestController
public class ProductCheckoutController {
    

    private StripeService stripeService;


    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts( @RequestBody ProductRequest productRequest) {
        StripeResponse stripeResponse = stripeService.checkoutProducts(productRequest);

        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stripeResponse);
    }
}
