package com.example.interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userRole = request.getHeader("x-user-role");
        if(userRole!= null && !userRole.equals("Admin")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\n" +
                    "    \"message\": \"You are not authorized to perform this actions.\"\n" +
                    "}");
            return false;
        }

        return  true;
    }
}
