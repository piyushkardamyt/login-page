package com.loginpagewithsecurity.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginpagewithsecurity.dao.UserRepository;
import com.loginpagewithsecurity.entity.User;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final UserRepository userRepository;
	
	
	
	public AdminController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

}
