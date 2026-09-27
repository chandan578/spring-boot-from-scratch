package com.example.CurdApplication.controller;

import com.example.CurdApplication.dto.CreateStudentReqDTO;
import com.example.CurdApplication.dto.CreateStudentResDTO;
import com.example.CurdApplication.dto.UpdateStudentReqDTO;
import com.example.CurdApplication.dto.UpdateStudentResDTO;
import com.example.CurdApplication.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResDTO> createStudent(@Valid @RequestBody CreateStudentReqDTO req){

        CreateStudentResDTO createdStudent = studentService.createStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResDTO> getStudent(@PathVariable Long id){
        CreateStudentResDTO res = studentService.getStudent(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResDTO>> getAllStudent(){
        List<CreateStudentResDTO> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }


    @PutMapping
    public ResponseEntity<UpdateStudentResDTO> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentReqDTO studentReq){
        UpdateStudentResDTO res = studentService.updateStudent(id, studentReq);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    // soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftlyStudent(@RequestParam Long id){
        studentService.deleteSoftlyStudent(id);

        return ResponseEntity.noContent().build();
    }
}
