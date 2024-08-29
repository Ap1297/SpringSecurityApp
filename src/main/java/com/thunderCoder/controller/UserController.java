package com.thunderCoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thunderCoder.model.Users;
import com.thunderCoder.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return service.register(user);
	}

	@PostMapping("/login")
	public String login(Users user) {
		System.out.println(user.getUsername());
		return service.verify(user);
	}
}
