package com.example.aopSpring.service;

import com.example.aopSpring.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{

    private LoggingServiceDecorator loggingServiceDecorator;
    public ExecutionTimeService(LoggingServiceDecorator loggingServiceDecorator){
        this.loggingServiceDecorator = loggingServiceDecorator;
    }

    @Override
    public void createStudent(Student student) {
        Long startTime = System.currentTimeMillis();

        loggingServiceDecorator.createStudent(student);

        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
