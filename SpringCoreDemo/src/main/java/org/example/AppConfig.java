package org.example;


import org.example.payment.CardPayment;
import org.example.payment.PaymentService;
import org.example.payment.UpiPayment;
import org.library.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // Bean is highest priority compare to @Component
    @Bean
    public User createUser(){
        return new User("Chandan", 24);
    }

    @Bean
    public CartService cartService(){
        return new CartService();
    }

    @Bean
    @Qualifier
    public PaymentService cardPayment(){
        return new CardPayment();
    }

    @Bean
//    @Primary
    @Qualifier
    public PaymentService upiPayment(){
        return new UpiPayment();
    }

    @Bean
    public OrderService orderService(@Qualifier("cardPayment") PaymentService pay){
        return new OrderService(pay);
    }
}
