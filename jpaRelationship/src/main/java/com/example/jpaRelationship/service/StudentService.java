package com.example.jpaRelationship.service;

import com.example.jpaRelationship.model.Department;
import com.example.jpaRelationship.model.Student;
import com.example.jpaRelationship.repository.DepartmentRepository;
import com.example.jpaRelationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentRepository studentRepository;

    public DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId){
        Department department = departmentRepository.getDepartmentById(deptId);

        student.setDepartment(department);
        department.getStudentList().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName){
        Department department = new Department();
        department.setName(deptName);
        student.setDepartment(department);
        department.getStudentList().add(student);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
