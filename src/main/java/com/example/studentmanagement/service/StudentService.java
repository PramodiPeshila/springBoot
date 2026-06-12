package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.StudentEntity;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//	public Optional<StudentEntity> getStudentById(Long id) {
//		return repository.findById(id);
//	}

	public StudentEntity updateStudentName(Long id, String name) {
		Optional<StudentEntity> student = repository.findById(id);
		if (student.isPresent()) {
			StudentEntity existingStudent = student.get();
			existingStudent.setName(name);
			return repository.save(existingStudent);
		}
		return null;
	}


}


