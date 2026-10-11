package com.example.aop.service;


import com.example.aop.annotation.TrackExecutionTime;
import com.example.aop.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    @Timestamp
    @TrackExecutionTime(
            warnAfter = 1000,
            operation = "Creating a student record"
    )
    public Student createStudent(Student student){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Student is saved..");
//        throw new RuntimeException("Some error occurs");
        return student;
    }

    @Override
    @TrackExecutionTime(
            warnAfter = 500,
            operation = "Get Student data"
    )
    public String getStudentName(String s){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("getStudentName method executed...");
        return  s;
    }
}
