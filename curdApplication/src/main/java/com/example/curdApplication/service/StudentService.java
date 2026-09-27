package com.example.CurdApplication.service;

import com.example.CurdApplication.dto.CreateStudentReqDTO;
import com.example.CurdApplication.dto.CreateStudentResDTO;
import com.example.CurdApplication.dto.UpdateStudentReqDTO;
import com.example.CurdApplication.dto.UpdateStudentResDTO;
import com.example.CurdApplication.entity.Student;
import com.example.CurdApplication.exception.DuplicateResourceException;
import com.example.CurdApplication.exception.RescourceNotFoundException;
import com.example.CurdApplication.repository.StudentRepository;
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

        if(emailExists(student)){
            throw new DuplicateResourceException("Student email id "+ student.getEmail()+ " already exist.");
        }
        Student studentRes = studentRepository.save(student);

        return mapToDTO(studentRes);
    }

    public CreateStudentResDTO getStudent(Long id){
        Student studentResp = studentRepository.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(()-> new RescourceNotFoundException("Student with id "+ id+" not found."));

        return mapToDTO(studentResp);
    }

    public List<CreateStudentResDTO> getAllStudent(){
        List<Student> studentList = studentRepository.findByIsDeletedIsFalse();

        return  studentList.stream().map(this::mapToDTO).toList();
    }

    public UpdateStudentResDTO updateStudent(Long id, UpdateStudentReqDTO studentReq){
        Student prevData = studentRepository.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(()-> new RescourceNotFoundException("Student with id "+ id+ " not found..."));

        prevData.setSubject(studentReq.getSubject());
        prevData.setRollNo(studentReq.getRollNo());
        prevData.setName(studentReq.getName());
        prevData.setAge(studentReq.getAge());
        prevData.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(prevData);
        return mapToUpdateDTO(updatedStudent);
    }

    public void deleteStudent(Long id){
        Student isStudentToBe = studentRepository.findById(id)
                .orElseThrow(()-> new RescourceNotFoundException("Student with id "+ id+ " not found.."));

        studentRepository.deleteById(id);
    }

    public void deleteSoftlyStudent(Long id){
        Student prevData = studentRepository.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(()-> new RescourceNotFoundException("Student with id "+ id + " not found.."));

        prevData.setDeleted(true);
        studentRepository.save(prevData);
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

    public boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}
