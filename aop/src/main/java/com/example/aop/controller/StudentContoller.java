package com.example.aop.controller;

import com.example.aop.dto.Student;
import com.example.aop.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentContoller {

    private StudentService studentService;
    public StudentContoller(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student res = studentService.createStudent(student);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<String> getStudentName(){
        String name = studentService.getStudentName("chandan");
        return ResponseEntity.ok(name);
    }
}
