package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationPointCuts {

    @Pointcut("within(com.example.aop.service..*)")
    public void serviceLayer(){
        // empty body..
    }

    @Pointcut("within(com.example.aop.repository..*)")
    public void repositoryLayer(){
        // empty body..
    }

    @Pointcut("within(com.example.aop.controller..*)")
    public void controllerLayer(){
        // empty body..
    }

    @Pointcut("within(com.example.aop.dto..*)")
    public void dtoLayer(){
        // empty body..
    }

    @Pointcut("execution(public * *(..)")
    public void publicMethods(){
        // empty body..
    }

    @Pointcut("publicMethods() && serviceLayer()")
    public void publicServiceMethods(){
        // empty body..
    }

    @Pointcut("execution(* * get*(..)")
    public void getterMethod(){
        // empty body..
    }

}
