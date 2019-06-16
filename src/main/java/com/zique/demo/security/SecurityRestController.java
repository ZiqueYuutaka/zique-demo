package com.zique.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zique.demo.service.DataService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SecurityRestController {
	
	@Autowired
	private DataService dataService;

	@GetMapping("/auth")
	public AuthBean hello(){
		return new AuthBean("You are authenticated");
	}
	
	
	
	
}
