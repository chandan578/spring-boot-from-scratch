package com.example.aop.aspect;

import com.example.aop.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String com.example.aop.service.StudentService.createStudent())")
//    public void logBeforeMethod(){
//        System.out.println("form logBefore, Student is going to be saved...");
//    }

//    @AfterReturning(value = "execution(* com.example.aop.service.StudentService.createStudent(..))", returning = "result")
//    public void logAfterMethod(Student result){
//        result.setName("Chandan");
//        result.setAge(23);
//
//        System.out.println("log after method execution.....");
//        System.out.println("Target result : "+ result);
//    }

//    @AfterThrowing(value = "execution(* com.example.aop.service.StudentService.createStudent(..))", throwing = "exception")
//    public void logAfterThrowMethod(RuntimeException exception){
//        System.out.println("Exception type: "+ exception.getClass().getName());
//        System.out.println("Exception message: "+ exception.getMessage());
//    }

//    @After(value = "execution(* com.example.aop.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("logAfterMethod executed..");
//    }

//    @Around(value = "execution(* com.example.aop.service.StudentService.createStudent(..))")
//    public Student logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before logAround executed..");
//        System.out.println("Execution started: "+ joinPoint.getSignature().getName());
//
//        try {
//            Student student = (Student) joinPoint.proceed();
//            System.out.println("Execution successfully...");
//            return student;
//        }catch (Exception e){
//            System.out.println("Execution failed: "+ e.getMessage());
//            throw e;
//        }
//        finally {
//            System.out.println("Execution completed...");
//            System.out.println("After logAround executed..");
//        }
//
////        return student;
//    }

    @Around(value = "execution(* com.example.aop.service.StudentService.getStudentName(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] arr = joinPoint.getArgs();
        String name = (String) arr[0];
        String modifiedName = name.toUpperCase();
        Object[] modified = {
                modifiedName
        };
        String returnData = (String) joinPoint.proceed(modified) + " : Intercepted data";

        return returnData;
    }
}
