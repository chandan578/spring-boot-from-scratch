package com.example.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect2 {

//    @Before("execution(public String com.example.aop.service.StudentService.getStudentName(" +
//            "com.example.aop.dto.Student))")
//    public void loggingBeforeMethod(){
//        System.out.println("Before method executed...");
//    }

//    @Before("execution(* com.example.aop..*(..))")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("within(com.example.aop..*)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("@annotation(jdk.jfr.TimeStamp)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("bean(studentService)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("within(com.example.aop.service..*) &&" +
//            "execution(public * *(..))")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Pointcut("within(com.example.aop.service..*) && execution(public * *(..))")
//    public void logPublicServiceMethod(){
//        // empty body always
//        // no logic here
//    }

//    @Before("logPublicServiceMethod()")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("com.example.aop.aspect.ApplicationPointCuts.getterMethod()")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }


//    @Before("@within(org.springframework.stereotype.Service)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }
//    @target() --> this is also same as @within() but when we use with inheritance then @target work and @within not work with inheritance....

//    @Before("args(com.example.aop.dto.Student) &&" +
//            "within(com.example.aop.service..*)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("@args(jdk.jfr.Timestamp) &&" +
//            "within(com.example.aop.service..*)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

//    @Before("target(com.example.aop.service.StudentService)")
//    public void loggingBeforeMethod2(){
//        System.out.println("Before method intercepted...");
//    }

    @Before("this(com.example.aop.service.StudentService)")
    public void loggingBeforeMethod2(){
        System.out.println("Before method intercepted...");
    }
    // In both target and this pointcut expression, it changes depending on the proxy type. There are two types of proxies in Spring AOP: JDK dynamic proxies and CGLIB proxies, by default uses CGLIB proxies. When we use CGLIB proxies, the target pointcut expression will match the proxy object, while the this pointcut expression will match the actual target object.
    // when we use JDK dynamic proxies, the target pointcut expression will match the actual target object, while the this pointcut expression will match the proxy object.

}
