package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Marks;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.MarksRepository;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class MarksService {
    private final MarksRepository marksRepo;
    private final StudentRepository studentRepo;

    public MarksService(MarksRepository marksRepo,StudentRepository studentRepo){
        this.marksRepo=marksRepo; this.studentRepo=studentRepo;
    }

    public Marks getByStudent(Long studentId){
        return marksRepo.findByStudentId(studentId).orElseGet(()->{
            Marks m=new Marks();
            m.setStudent(studentRepo.findById(studentId).orElseThrow(()->new RuntimeException("Student not found")));
            return m;
        });
    }

    public Marks save(Long studentId,Marks input){
        Student student=studentRepo.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
        Marks m=marksRepo.findByStudentId(studentId).orElse(new Marks());
        m.setStudent(student);
        m.setJavaMarks(input.getJavaMarks());
        m.setDbmsMarks(input.getDbmsMarks());
        m.setDataStructuresMarks(input.getDataStructuresMarks());
        m.setComputerNetworksMarks(input.getComputerNetworksMarks());
        m.setOperatingSystemsMarks(input.getOperatingSystemsMarks());
        return marksRepo.save(m);
    }
}
