package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.StudentEntity;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return repository.save(student);
    }

    @GetMapping
    public List<StudentEntity> getStudents() {
        return repository.findAll();
    }
}

// added new commmitsss


