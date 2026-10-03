package com.example.interceptor.config;

import com.example.interceptor.interceptors.AuthenticationInterceptor;
import com.example.interceptor.interceptors.AuthorizationInterceptor;
import com.example.interceptor.interceptors.LoggingInterceptor;
import com.example.interceptor.interceptors.TimeCalculationIterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LoggingInterceptor loggingInterceptor;
    private AuthorizationInterceptor authorizationInterceptor;
    private AuthenticationInterceptor authenticationInterceptor;
    private TimeCalculationIterceptor timeCalculationIterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor,
                     TimeCalculationIterceptor timeCalculationIterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
        this.timeCalculationIterceptor = timeCalculationIterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/student/login", "/api/public/**")
                .order(1);

        registry.addInterceptor(loggingInterceptor).order(3);
        registry.addInterceptor(authorizationInterceptor).order(2);
        registry.addInterceptor(timeCalculationIterceptor).order(4);
    }
}
