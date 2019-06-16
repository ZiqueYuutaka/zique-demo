package com.zique.demo.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zique.demo.service.DataService;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SecurityRestController {

	@GetMapping("/auth")
	public AuthBean hello(){
		return new AuthBean("You are authenticated");
	}
	
	
	
	
}
