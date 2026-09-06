package com.example.SpringBootApplicationProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {


    private PaymentProperties paymentProperties;
    public PaymentGateway(PaymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }

    public String getType(){
        return paymentProperties.getType();
    }

    public int getRetryCount(){
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled(){
        return paymentProperties.isEnabled();
    }

    public int getTimeOut(){
        return paymentProperties.getTimeOut();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getTimeOut());
        System.out.println(isEnabled());
    }



//    when we don't use the PaymentProperties.java file
//    @Value("${paymentGateway.type:Razorpay}")  // Add here also by default type...
//    private String type;
//    @Value("${paymentGateway.retry-count}")
//    private int retryCount;

//    public PaymentGateway(@Value("${paymentGateway.type}") String type, @Value("${paymentGateway.retry-count}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }

}
