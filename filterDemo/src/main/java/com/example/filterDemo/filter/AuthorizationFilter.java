package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@Order(1)
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = ((HttpServletRequest) request).getHeader("token");
        String apiKey = ((HttpServletRequest) request).getHeader("x-api-key");
        if(token == null || !token.equals("12345")){
            httpServletResponse.setStatus(httpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("{\n" +
                    "    \"message\": \"Authentication is required...\"\n" +
                    "}");
            return;
        }

        if(apiKey==null || !apiKey.equals("kittu123")){
            httpServletResponse.setStatus(httpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("{\n" +
                    "    \"message\": \"Invalid or missing api key..\"\n" +
                    "}");
            return;
        }

        chain.doFilter(request, response);
    }
}
