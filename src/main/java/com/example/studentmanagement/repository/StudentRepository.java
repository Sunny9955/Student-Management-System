package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByNameContainingIgnoreCaseOrRollNumberContainingIgnoreCaseOrCourseContainingIgnoreCase(
            String name,String rollNumber,String course);
}
