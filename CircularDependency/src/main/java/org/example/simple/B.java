package org.example.simple;

public class B {

    private A a;
    public B(){
        System.out.println("B is created...");
        this.a = new A();
    }
}
