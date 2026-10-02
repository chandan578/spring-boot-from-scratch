package com.example.filterDemo.service;

import com.example.filterDemo.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student){
        System.out.println("Student created...");
        System.out.println("ID: "+student.getName());
        System.out.println("Name: "+student.getName());
        System.out.println("EmailID: "+student.getEmailId());

//        try {
//            Thread.sleep(3000);
//        }catch (Exception err) {}
    }
}
