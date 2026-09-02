package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public OrderService getOrder(){
        return new OrderService();
    }

    @Bean
    public OrderService findOrder(){
        return new OrderService();
    }


}
