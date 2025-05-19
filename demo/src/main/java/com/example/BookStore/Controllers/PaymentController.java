package com.example.BookStore.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.stripe.exception.StripeException;
import com.stripe.model.Card;

import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.Builder;
import com.stripe.model.checkout.Session;




@Controller
public class PaymentController {
    


    @PostMapping("/checkoutSession")
    public Map<String, Object> createCheckoutSession() throws StripeException {

        SessionCreateParams params = SessionCreateParams.builder()
            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("")
            .setCancelUrl("")
            .addLineItem(
                    SessionCreateParams.LineItem.builder()
                            .setPriceData(
                                    SessionCreateParams.LineItem.PriceData.builder()
                                        .setCurrency("usd")
                                        .setUnitAmount(100L)
                                        .setProductData(
                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                    .setName("Test Product")
                                                    .build()
                                        )
                                        .build()
                            ).setQuantity(1L)
                            .build()
            )
            .build();

        Session session  = Session.create(params);
        Map<String, Object> result = new HashMap<>();
        result.put("sessionId", session.getId());

        return ResponseEntity.ok(result).getBody();
    }
}
