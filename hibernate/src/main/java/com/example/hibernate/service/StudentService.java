package com.example.hibernate.service;

import com.example.hibernate.model.Student;
import com.example.hibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public String createStudent(Student student){
        studentRepository.save(student);
        return "Student created..";
    }

    @Transactional
    public String updateStudent(Student student, Long id){
        Student student1 = studentRepository.findById(id);

        if(student1==null){
            throw new RuntimeException("Student not found..");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());

        return "Student updated..";
    }

    @Transactional
    public String deleteStudent(Long id){
        Student student = studentRepository.findById(id);
        if(student==null){
            throw new RuntimeException("Student not found..");
        }
        studentRepository.remove(student);

        return  "Deleted student..";
    }

    public Student getStudentById(Long id){
        Student student = studentRepository.findById(id);

        return student;
    }

    public List<Student> getStudent(){
//        List<Student> studentList = studentRepository.getStudent();
        return null;
    }
}
