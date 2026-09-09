package com.example.curdApplication.repository;

import com.example.curdApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndIsDeletedIsFalse(Long id);

    List<Student> findByIsDeletedIsFalse();
}
