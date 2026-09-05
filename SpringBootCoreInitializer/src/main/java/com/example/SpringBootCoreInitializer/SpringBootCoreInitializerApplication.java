package com.example.SpringBootCoreInitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreInitializerApplication {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootCoreInitializerApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

	}

}
