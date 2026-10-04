package com.example.aopSpring.service;

public class LoggingServiceUtils {

    public static void logStart(String className, String methodName){
        System.out.println("Executing -> class name: "+ className + ", method name: "+ methodName);
    }

    public static void logEnd(String className, String methodName){
        System.out.println("Finish -> class name: "+ className + ", method name: "+ methodName);
    }
}
