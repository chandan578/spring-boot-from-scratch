package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Lazy
public class PaymentService {

    private OrderService orderService;
    public PaymentService(OrderService orderService){

        this.orderService = orderService;
        System.out.println("Payment service created...");
    }

    public void pay(){
        System.out.println("Payment done...");
//        orderService.placedOrder();
    }
}
