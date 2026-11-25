package com.example.jpaRelationship.controller;


import com.example.jpaRelationship.model.Student;
import com.example.jpaRelationship.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    public StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId){
        studentService.createStudent(student, deptId);

        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudetnt(@RequestBody Student student, @RequestParam String deptName){
        studentService.createStudent(student, deptName);

        return ResponseEntity.ok("Done");
    }

}
