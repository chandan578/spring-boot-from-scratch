package com.example.aop.service;


import com.example.aop.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    @Timestamp
    public Student createStudent(Student student){
        System.out.println("Student is saved..");
//        throw new RuntimeException("Some error occurs");
        return student;
    }

    @Override
    public String getStudentName(String s){
        System.out.println("getStudentName method executed...");
        return  s;
    }
}
