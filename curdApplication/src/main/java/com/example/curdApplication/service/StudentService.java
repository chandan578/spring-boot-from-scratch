package com.example.curdApplication.service;

import com.example.curdApplication.entity.Student;
import com.example.curdApplication.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        System.out.println("inside service");
        Student studentRes = studentRepository.saveStudent(studentReq);
        System.out.println("exit service");
        return studentRes;
    }
}
