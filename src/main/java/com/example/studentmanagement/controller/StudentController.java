package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.ApiResponse;
import com.example.studentmanagement.entity.StudentEntity;
import com.example.studentmanagement.service.StudentService;
import com.example.studentmanagement.dto.UpdateStudentNameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<StudentEntity> getStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<ApiResponse> updateStudentName(@PathVariable Long id, @RequestBody UpdateStudentNameDto dto) {
        StudentEntity updatedStudent = service.updateStudentName(id, dto.getName());
        if (updatedStudent != null) {
            return ResponseEntity.ok(new ApiResponse("Student name updated successfully", true));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Student not found", false));
    }
}

// added new commmitsssmm
// kj

