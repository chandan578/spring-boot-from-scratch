package com.example.SpringBootCoreInitializer;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay(){
        System.out.println("Payment successfully done..");
    }
}
