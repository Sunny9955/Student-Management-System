package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    @NotBlank
    private String rollNumber;

    @Column(nullable=false)
    @NotBlank
    private String name;

    @Column(nullable=false)
    @Email
    @NotBlank
    private String email;

    @Column(nullable=false)
    @NotBlank
    private String course;

    @Min(1)
    @Max(6)
    private int year;

    public Student() {}

    public Long getId(){return id;}
    public String getRollNumber(){return rollNumber;}
    public void setRollNumber(String v){rollNumber=v;}
    public String getName(){return name;}
    public void setName(String v){name=v;}
    public String getEmail(){return email;}
    public void setEmail(String v){email=v;}
    public String getCourse(){return course;}
    public void setCourse(String v){course=v;}
    public int getYear(){return year;}
    public void setYear(int v){year=v;}
}
