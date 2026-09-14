package org.example.repository;

import org.example.entity.Student;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentRepository {

    Map<Long, Student> studentDB;

    public StudentRepository(){
        studentDB = new HashMap<>();
    }

    public Student save(Student req){
        studentDB.put(req.getId(), req);
        return req;
    }

    public Student findByID(Long id){
        return studentDB.get(id);
    }

    public List<Student> findAll(){
        return new ArrayList<>(studentDB.values());
    }

}
