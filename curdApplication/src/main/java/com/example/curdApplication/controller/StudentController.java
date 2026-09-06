package com.example.curdApplication.controller;

import com.example.curdApplication.entity.Student;
import com.example.curdApplication.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create
//    @PostMapping("/create") // when we want to use unique name for every api....
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Inside controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("exit controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // read


    // update


    // delete
}
