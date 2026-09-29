package com.example.profilingDemo;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default", "staging"})
public class DummyNotificationServiceImp implements NotificationService {
    @Override
    public String send() {
        return "Here is dummy notification...";
    }
}
