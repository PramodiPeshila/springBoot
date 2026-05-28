package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.StudentEntity;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	private final StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public StudentEntity saveStudent(StudentEntity student) {
		return repository.save(student);
	}

	public List<StudentEntity> getAllStudents() {
		return repository.findAll();
	}
}


