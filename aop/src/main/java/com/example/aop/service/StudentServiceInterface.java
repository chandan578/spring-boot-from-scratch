package com.example.aop.service;

import com.example.aop.dto.Student;

public interface StudentServiceInterface {

    Student createStudent(Student student);

    String getStudentName(String s);
}
