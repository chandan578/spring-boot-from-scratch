package com.example.filterDemo.controller;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.dto.StudentResDto;
import com.example.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResDto> createStudent(@RequestBody Student student){

        StudentResDto studentResDto = studentService.createStudent(student);
        return ResponseEntity.ok(studentResDto);
    }
}
