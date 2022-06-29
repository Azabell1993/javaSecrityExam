package com.jiwoo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/member")
	public void formember() {
		
	}
	
	@GetMapping("/login")
	public void forlogin() {
		
	}
}
