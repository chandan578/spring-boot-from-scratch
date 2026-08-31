package org.example.simple;

public class A {

    private B b;
    public A(){
        System.out.println("A is created...");
        this.b = new B();
    }
}
