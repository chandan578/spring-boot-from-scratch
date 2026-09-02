package org.example;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  // we can use this or by default also this bean scope working..
//@Scope("prototype")
public class OrderService {

    public OrderService(){
        System.out.println("OrderService Created...");
    }

    public void placeOrder(){
        System.out.println("Order placed successfully...");
    }
}
