package com.example.curdApplication.repository;

import com.example.curdApplication.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        System.out.println("Inside repository..");
        Student s1 = new Student();
        s1.setAge(24);
        s1.setEmail("chandu@gmail.com");
        s1.setName("chandu");
        s1.setRollNo(112);
        s1.setSubject("Angular");
        System.out.println("exit repository..");
        return s1;
    }
}
