package com.example.filterDemo.config;

import com.example.filterDemo.filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FIlterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilter(){
        FilterRegistrationBean<DummyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());
//        registrationBean.setOrder(2);

        registrationBean.addUrlPatterns("/api/*");
        return  registrationBean;
    }
}
