package com.thunderCoder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thunderCoder.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<Student> studentList= new ArrayList<>(List.of(
			new Student(1, "ANkit", 83),
			new Student(1, "Smita", 89)
			));
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentList;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/students")
	public Student addStudents(@RequestBody Student student){
		studentList.add(student);
		return student; 
	}
	
	
}
