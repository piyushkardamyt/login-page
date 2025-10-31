package com.loginpagewithsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login-page")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/support")
	public String support() {
		return "support";
	}

}
