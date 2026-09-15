package com.example.curdApplication.controller;

import com.example.curdApplication.dto.CreateStudentReqDTO;
import com.example.curdApplication.dto.CreateStudentResDTO;
import com.example.curdApplication.dto.UpdateStudentReqDTO;
import com.example.curdApplication.dto.UpdateStudentResDTO;
import com.example.curdApplication.entity.Student;
import com.example.curdApplication.service.StudentService;
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

    // create
    @PostMapping("/create") // when we want to use unique name for every api....
//    @PostMapping
    public ResponseEntity<CreateStudentResDTO> createStudent(@Valid @RequestBody CreateStudentReqDTO req){

        CreateStudentResDTO createdStudent = studentService.createStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // read
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable Long id){
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResDTO> getStudent(@RequestParam Long id){
        CreateStudentResDTO res = studentService.getStudent(id);
        if(res==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);

//        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResDTO>> getAllStudent(){
        List<CreateStudentResDTO> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }


    // update
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResDTO> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentReqDTO studentReq){
        UpdateStudentResDTO res = studentService.updateStudent(id, studentReq);
        if(res==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);

//        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    // delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record Deleted.");
    }

    // soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftlyStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteSoftlyStudent(id);

        if(!isDeleted) return ResponseEntity.notFound().build();

        return ResponseEntity.ok("Record Deleted..");
    }
}
