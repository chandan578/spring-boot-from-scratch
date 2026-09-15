package com.example.curdApplication.service;

import com.example.curdApplication.dto.CreateStudentReqDTO;
import com.example.curdApplication.dto.CreateStudentResDTO;
import com.example.curdApplication.dto.UpdateStudentReqDTO;
import com.example.curdApplication.dto.UpdateStudentResDTO;
import com.example.curdApplication.entity.Student;
import com.example.curdApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResDTO createStudent(CreateStudentReqDTO req){
        Student student = mapToEntity(req);
        Student studentRes = studentRepository.save(student);

        return mapToDTO(studentRes);
    }

    public CreateStudentResDTO getStudent(Long id){
        Optional<Student> res = studentRepository.findByIdAndIsDeletedIsFalse(id);

        if(res.isPresent()) return mapToDTO(res.get());

        return null;
    }

    public List<CreateStudentResDTO> getAllStudent(){
        List<Student> studentList = studentRepository.findByIsDeletedIsFalse();

        return  studentList.stream().map(this::mapToDTO).toList();
    }

    public UpdateStudentResDTO updateStudent(Long id, UpdateStudentReqDTO studentReq){
        Optional<Student>  prevData = studentRepository.findByIdAndIsDeletedIsFalse(id);
        if(prevData.isEmpty()) return null;

        Student updatedData = prevData.get();
        updatedData.setSubject(studentReq.getSubject());
        updatedData.setRollNo(studentReq.getRollNo());
        updatedData.setName(studentReq.getName());
        updatedData.setAge(studentReq.getAge());
        updatedData.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(updatedData);
        return mapToUpdateDTO(updatedStudent);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return  false;

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteSoftlyStudent(Long id){
        Optional<Student> prevData = studentRepository.findByIdAndIsDeletedIsFalse(id);
        if(prevData.isEmpty()) return false;

        Student updateData = prevData.get();
        updateData.setDeleted(true);
        studentRepository.save(updateData);
        return true;
    }

    public Student mapToEntity(CreateStudentReqDTO reqDTO){
        Student student = new Student();
        student.setName(reqDTO.getName());
        student.setAge(reqDTO.getAge());
        student.setEmail(reqDTO.getEmail());
        student.setRollNo(reqDTO.getRollNo());
        student.setSubject(reqDTO.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setDeleted(false);

        return student;
    }

    public CreateStudentResDTO mapToDTO(Student student){
        CreateStudentResDTO studentResDTO = new CreateStudentResDTO();
        studentResDTO.setId(student.getId());
        studentResDTO.setName(student.getName());
        studentResDTO.setAge(student.getAge());
        studentResDTO.setEmail(student.getEmail());
        studentResDTO.setRollNo(student.getRollNo());
        studentResDTO.setSubject(student.getSubject());
        studentResDTO.setCreatedAt(student.getCreatedAt());
        studentResDTO.setUpdatedAt(student.getUpdatedAt());
        studentResDTO.setMessage("Student saved successfully..");

        return  studentResDTO;
    }

    private UpdateStudentResDTO mapToUpdateDTO(Student student){
        UpdateStudentResDTO studentResDTO = new UpdateStudentResDTO();
        studentResDTO.setId(student.getId());
        studentResDTO.setName(student.getName());
        studentResDTO.setAge(student.getAge());
        studentResDTO.setRollNo(student.getRollNo());
        studentResDTO.setSubject(student.getSubject());
        studentResDTO.setUpdatedAt(student.getUpdatedAt());
        studentResDTO.setMessage("Student updated successfully..");

        return  studentResDTO;
    }
}
