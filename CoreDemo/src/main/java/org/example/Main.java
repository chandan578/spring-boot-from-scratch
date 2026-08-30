package org.example;

import org.example.notification.EmailService;
import org.example.notification.NotificationService;
import org.example.notification.PopUpNotificationService;
import org.example.notification.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        NotificationService notification = new EmailService();
//        OrderService order = new OrderService(notification);
        OrderService order = new OrderService();
        order.setNotification(notification);
        order.orderPlace();
    }
}