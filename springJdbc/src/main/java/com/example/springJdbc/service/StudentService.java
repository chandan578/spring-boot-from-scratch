package com.example.springJdbc.service;

import com.example.springJdbc.model.Student;
import com.example.springJdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public String createStudent(Student student){
        studentRepository.createStudent(student);
        return "Student created..";
    }

    public String updateStudent(Student student, Long id){
        studentRepository.updateStudent(student, id);
        return "Student updated..";
    }

    public String deleteStudent(Long id){
        studentRepository.deleteStudent(id);

        return  "Deleted student..";
    }

    public Student getStudentById(Long id){
        Student student = (Student) studentRepository.getStudentById(id);
        return student;
    }

    public List<Student> getStudent(){
        List<Student> studentList = studentRepository.getStudent();
        return studentList;
    }

}
