package com.example.demo.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class WelcomeController {
	
	@GetMapping(path = "/students") //in spring security GetMapping has already got 'produces'
	public String getStudent() {
		return "Student Suresh";
	}
	
	@GetMapping(path = "/teachers")
	public String getTeacher() {
		return "Teacher Thanvi";
	}
	
	@GetMapping(path = "/staff")
	public String getStaff(Principal principal) {
		System.out.println("Accessed By ="+principal.getName());
		return "Staff Shilpa";
	}

}
