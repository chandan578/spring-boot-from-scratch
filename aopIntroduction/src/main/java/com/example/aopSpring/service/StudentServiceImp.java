package com.example.aopSpring.service;

import com.example.aopSpring.dto.Student;
import com.example.aopSpring.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository repository){
        this.studentRepository = repository;
    }

    public void createStudent(Student student){
        try {
            Thread.sleep(2000);
        }catch (Exception ex){

        }
        studentRepository.save();
    }
}
