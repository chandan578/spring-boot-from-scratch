package com.example.CurdApplication.repository;

import com.example.CurdApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndIsDeletedIsFalse(Long id);

    List<Student> findByIsDeletedIsFalse();
    Boolean existsByEmail(String emailId);
}
