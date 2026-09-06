package com.example.SpringBootApplicationProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApplicationPropertyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootApplicationPropertyApplication.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

//		paymentGateway.setType("Paytm");
//		paymentGateway.setRetryCount(5);

//		paymentGateway.print();

	}

}
