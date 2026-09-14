package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student req){
        Student res = studentService.createStudent(req);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student res = studentService.getStudent(id);
        if(res==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> res = studentService.getAllStudent();
        return ResponseEntity.ok(res);
    }
}
