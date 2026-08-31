package org.example;

import org.library.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placedOrder();

//        CartService cartService = new CartService();
//        cartService.addToCart();

        User user = context.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user.getAge());

        CartService cart = context.getBean(CartService.class);
        cart.addToCart();


    }
}