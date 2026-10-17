package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createStudent(new Student("chandu", "chandu@hotmail.com", 24));
//        studentRepository.updateStudent(new Student("chandu", "chandu@outlook.com", 27), 2L);
//        studentRepository.deleteStudent(5L);

        studentRepository.getStudentById(3L);
        studentRepository.getStudent();
//        studentRepository.completeCRUD();
    }

}