package com.example.studentmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional=false)
    @JoinColumn(name="student_id", unique=true)
    private Student student;

    private int javaMarks;
    private int dbmsMarks;
    private int dataStructuresMarks;
    private int computerNetworksMarks;
    private int operatingSystemsMarks;

    public Marks() {}

    public Long getId(){return id;}
    public Student getStudent(){return student;}
    public void setStudent(Student v){student=v;}
    public int getJavaMarks(){return javaMarks;}
    public void setJavaMarks(int v){javaMarks=v;}
    public int getDbmsMarks(){return dbmsMarks;}
    public void setDbmsMarks(int v){dbmsMarks=v;}
    public int getDataStructuresMarks(){return dataStructuresMarks;}
    public void setDataStructuresMarks(int v){dataStructuresMarks=v;}
    public int getComputerNetworksMarks(){return computerNetworksMarks;}
    public void setComputerNetworksMarks(int v){computerNetworksMarks=v;}
    public int getOperatingSystemsMarks(){return operatingSystemsMarks;}
    public void setOperatingSystemsMarks(int v){operatingSystemsMarks=v;}

    @Transient
    public int getTotal(){return javaMarks+dbmsMarks+dataStructuresMarks+computerNetworksMarks+operatingSystemsMarks;}

    @Transient
    public double getPercentage(){return Math.round((getTotal()/5.0)*100.0)/100.0;}

    @Transient
    public String getGrade(){
        double p=getPercentage();
        if(p>=90)return "A+";
        if(p>=80)return "A";
        if(p>=70)return "B";
        if(p>=60)return "C";
        if(p>=50)return "D";
        return "F";
    }
}
