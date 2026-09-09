package com.example.curdApplication.service;

import com.example.curdApplication.entity.Student;
import com.example.curdApplication.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        System.out.println("inside service");
        Student studentRes = studentRepository.save(studentReq);
        System.out.println("exit service");
        return studentRes;
    }

    public Student getStudent(Long id){
        Optional<Student> res = studentRepository.findById(id);

        if(res.isPresent()) return res.get();

        return null;
    }

    public List<Student> getAllStudent(){
        return  studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentReq){
        Optional<Student>  prevData = studentRepository.findById(id);
        if(prevData.isEmpty()) return null;

        Student updatedData = prevData.get();
        updatedData.setSubject(studentReq.getSubject());
        updatedData.setRollNo(studentReq.getRollNo());
        updatedData.setName(studentReq.getName());
        updatedData.setEmail(studentReq.getEmail());
        updatedData.setAge(studentReq.getAge());

        return studentRepository.save(updatedData);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return  false;

        studentRepository.deleteById(id);
        return true;
    }
}
