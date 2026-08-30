package org.example;

import org.example.notification.EmailService;
import org.example.notification.NotificationService;
import org.example.notification.PopUpNotificationService;
import org.example.notification.SmsService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public OrderService(){

    }

    public void orderPlace(){
        System.out.println("Order Placed...");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
