package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){this.repo=repo;}

    public List<Student> findAll(String keyword){
        if(keyword==null || keyword.isBlank()) return repo.findAll();
        return repo.findByNameContainingIgnoreCaseOrRollNumberContainingIgnoreCaseOrCourseContainingIgnoreCase(keyword,keyword,keyword);
    }
    public Student get(Long id){return repo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));}
    public Student save(Student s){return repo.save(s);}
    public Student update(Long id,Student s){
        Student old=get(id);
        old.setRollNumber(s.getRollNumber()); old.setName(s.getName());
        old.setEmail(s.getEmail()); old.setCourse(s.getCourse()); old.setYear(s.getYear());
        return repo.save(old);
    }
    public void delete(Long id){repo.deleteById(id);}
}
