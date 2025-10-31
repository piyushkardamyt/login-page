package com.loginpagewithsecurity.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginpagewithsecurity.dao.UserRepository;
import com.loginpagewithsecurity.entity.User;
import com.loginpagewithsecurity.service.UserService;

@RestController
@RequestMapping("/public")
public class UserController {
	
	
	private final UserRepository userRepository;
	
	private final UserService userService;
	
	public UserController(UserRepository userRepository, UserService userService) {
		super();
		this.userRepository = userRepository;
		this.userService = userService;
	}

	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.verify(user);
	}
}