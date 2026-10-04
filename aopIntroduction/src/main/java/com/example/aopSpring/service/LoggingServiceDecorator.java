package com.example.aopSpring.service;

import com.example.aopSpring.dto.Student;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingServiceDecorator implements StudentService {

    private StudentServiceImp studentServiceImp;
//    private LoggingServiceUtils loggingServiceUtils;

    public LoggingServiceDecorator(StudentServiceImp studentServiceImp){
        this.studentServiceImp = studentServiceImp;
    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtils.logStart("StudentService", "createStudent");

        studentServiceImp.createStudent(student);

        LoggingServiceUtils.logStart("StudentService", "createStudent");
    }
}
