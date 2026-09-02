package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Lazy
public class OrderService {

    private PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){

        this.paymentService = paymentService;
        System.out.println("Order service created...");
    }

    public void placedOrder(){
        paymentService.pay();

        System.out.println("Order placed successfully...");
    }


}
