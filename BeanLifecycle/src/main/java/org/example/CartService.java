package org.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
public class CartService /* implements InitializingBean */ {

    Map<Integer, String> mp;
    public CartService(){
        mp = new HashMap<>();
        System.out.println("CartService constructor called..");
    }

    public void addToCart(){
        System.out.println("Successfully added to cart...");
    }

    public String getValue(int key){
        return mp.get(key);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready...");
//        mp.put(1, "Chandan");
//        mp.put(2, "Kundan");
//    }

    public void start(){
        System.out.println("Bean is ready...");
        mp.put(1, "chandan");
        mp.put(2, "kundan");
    }
}
