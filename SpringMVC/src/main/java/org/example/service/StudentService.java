package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student req){
        return studentRepository.save(req);
    }

    public Student getStudent(Long id){
        return studentRepository.findByID(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }


}
