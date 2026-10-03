package com.example.interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        System.out.println("Incomming request-----");
        System.out.println("HTTP Method Name: "+ request.getMethod());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Request Parameter: "+ request.getQueryString());
        System.out.println("Client IP: "+ request.getRemoteAddr());
        System.out.println("Token Header: "+ request.getHeader("token"));


        if(handler instanceof HandlerMethod handlerMethod){
            String controllerName = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();

            System.out.println("preHandle function called..");
            System.out.println("Controller name : "+ controllerName);
            System.out.println("Method name: "+methodName);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView){
        System.out.println("postHandle function called...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex){
        System.out.println("afterCompletion function called...");
    }
}
