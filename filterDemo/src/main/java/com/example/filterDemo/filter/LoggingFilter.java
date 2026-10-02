package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
//@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String requestID = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID", requestID);

        long startTime = System.currentTimeMillis();

        System.out.println("Incoming request: "+
                ((HttpServletRequest) request).getMethod() + " " +
                ((HttpServletRequest) request).getRequestURI());

        chain.doFilter(request, response);

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("Response Status: " + ((HttpServletResponse) response).getStatus());
        System.out.println("API Response Time : "+ totalTime);
    }
}
