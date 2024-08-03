package com.thunderCoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/Hello")
	public String greet() {
		return "Welcome to telusko";
	}
}
