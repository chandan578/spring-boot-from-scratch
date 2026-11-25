package com.example.jpaRelationship.service;

import com.example.jpaRelationship.model.Department;
import com.example.jpaRelationship.model.Student;
import com.example.jpaRelationship.repository.DepartmentRepository;
import com.example.jpaRelationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository){
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName){
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        // JSON may send "studentList": null, so make sure the list exists
        if (department.getStudentList() == null) {
            department.setStudentList(new ArrayList<>());
        }
        department.getStudentList().add(student);

        // save the department first so the student's dept_id has a value
        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
