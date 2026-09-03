package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("userBean") // without initialize it give that class name
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService(){
        System.out.println("User Service");
    }

    @Override
    public void setBeanName(String name){
        System.out.println("Bean name : "+ name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context name is : "+ applicationContext.getClass());
    }
}

