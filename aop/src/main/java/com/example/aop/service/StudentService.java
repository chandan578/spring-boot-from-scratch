package com.example.aop.service;


import com.example.aop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){
        System.out.println("Student is saved..");
//        throw new RuntimeException("Some error occurs");
        return student;
    }

    public String getStudentName(String s){
        return  s;
    }
}
