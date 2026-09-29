package com.example.profilingDemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/welcome")
public class DemoController {

    @Value("${app.welcome.message}")
    private String message;

    @Value("200")
    private Integer statusCode;

    @Value("${app.welcome.users}")
    private List<String> names;

    @GetMapping
    public ResponseEntity<String> greet(){
        System.out.println(names);
        return ResponseEntity.ok(message+" " +statusCode);
    }
}
