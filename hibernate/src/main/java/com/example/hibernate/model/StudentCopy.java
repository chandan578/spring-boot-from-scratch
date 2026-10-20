package com.example.hibernate.model;

import jakarta.persistence.*;

import java.util.Set;

//@Entity
//@Table(name = "students")
public class StudentCopy {

    // this file used to replace the student file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "s_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            name = "s_email",
            unique = true,
            nullable = false,
            length = 110,
            insertable = true,
            updatable = true
    )
    private String email;

    @Column(nullable = false)
    private int age;

    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "student_address",
            joinColumns = @JoinColumn(name = "studentId")
    )
    private Set<Address> studentAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "currHouseNo")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "currCity")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "currStreet")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "currState")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "currPincode")
//            )
//    }
//
//    )
//    private Address currentAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "permHouseNo")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "permCity")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "permStreet")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "permState")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "permPincode")
//            )
//    })
//    private Address permanentAddress;

//    @Column(precision = 5, scale = 2)
//    private BigDecimal percentage;
//    private LocalDate dateOfBirth;
//    private LocalDateTime time;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//
//    @Lob
//    private String profileDescription;
//
//    @Transient
//    private String displayName;
//
//    @Convert(converter = ConvertBooleanToString.class)
//    private Boolean isMonitor;

    public StudentCopy() {
    }

    public StudentCopy(Long id, String name, String email, int age, Set<String> skills, Set<Address> studentAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.skills = skills;
        this.studentAddress = studentAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<Address> getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Set<Address> studentAddress) {
        this.studentAddress = studentAddress;
    }
}
