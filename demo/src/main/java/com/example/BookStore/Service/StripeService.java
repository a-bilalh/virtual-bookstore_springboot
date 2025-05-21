package com.example.BookStore.Service;

import org.springframework.security.core.session.SessionIdChangedEvent;

import com.example.BookStore.Domain.ProductRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.example.BookStore.Domain.StripeResponse;
import com.stripe.param.checkout.SessionCreateParams;

public class StripeService{


    public StripeResponse checkoutProducts( ProductRequest productRequest ) {

        Stripe.apiKey="";

        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(productRequest.getName()).build();

        SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(productRequest.getCurrency() == null ? "USD": productRequest.getCurrency())
                .setUnitAmount(productRequest.getAmount())
                .setProductData(productData)
                .build();

        SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setQuantity(productRequest.getQuantity())
                .setPriceData(priceData)
                .build();

        SessionCreateParams params = SessionCreateParams.builder()
            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("http://localhost:8080/success")
            .setCancelUrl("http://localhost:8080/cancel")
            .addLineItem(lineItem)
            .build();

        Session session = null;

        try {
            session = Session.create(params);
        } catch (StripeException e) {
            System.out.println(e.getMessage());
        }


        return StripeResponse.builder()
                    .status("Success")
                    .message("Payment session created")
                    .sessionId(session.getId())
                    .sessionUrl(session.getUrl())
                    .build();
    }


}