package com.example.profilingDemo;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImp implements NotificationService {

    @Override
    public String send(){
        return "Here is our notification services..";
    }
}
