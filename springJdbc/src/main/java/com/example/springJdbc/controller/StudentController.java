package com.example.springJdbc.controller;

import com.example.springJdbc.model.Student;
import com.example.springJdbc.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        String res = studentService.createStudent(student);

        return ResponseEntity.ok(res);
    }

    @PutMapping
    public  ResponseEntity<String> updateStudent(@RequestBody Student student, @RequestParam Long id){
        String res = studentService.updateStudent(student, id);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        String res = studentService.deleteStudent(id);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student res = studentService.getStudentById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        return ResponseEntity.ok(studentService.getStudent());
    }
}
