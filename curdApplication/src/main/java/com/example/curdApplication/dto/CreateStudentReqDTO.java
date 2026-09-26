package com.example.CurdApplication.dto;


import jakarta.validation.constraints.*;

public class CreateStudentReqDTO {

    @NotBlank(message = "Name is not blank/empty/only spaces.")
    @Size(min = 5, max = 20, message = "Name size is between 5 to 20 character.")
    private String name;

    @NotNull(message = "Age is required.")
    @Min(value = 18, message = "Age is atleast 18.")
    private Integer age;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email must be valid.")
    private String email;

    @NotNull(message = "RollNo is required.")
    private Integer rollNo;

    @NotBlank(message = "Subject is required.")
    @Size(min = 2, max = 10, message = "Subject name is between 2 to 10 character.")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
