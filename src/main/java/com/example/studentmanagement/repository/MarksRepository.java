package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MarksRepository extends JpaRepository<Marks,Long>{
    Optional<Marks> findByStudentId(Long studentId);
}
