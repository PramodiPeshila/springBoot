package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}


