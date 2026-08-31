package org.example;


import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService pservice;

//    Constructor Dependency Injection
    @Autowired
//    public OrderService(@Qualifier("up") PaymentService pay){
    public OrderService(PaymentService pay){
        this.pservice = pay;
    }

    public void placedOrder(){
        pservice.pay();

        System.out.println("Order Placed...");
    }

    // Setter Dependency Injection
//    @Autowired
//    public void setPservice(PaymentService pservice) {
//        this.pservice = pservice;
//    }
}
