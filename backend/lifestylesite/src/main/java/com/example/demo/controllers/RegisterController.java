package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	@PostMapping("/register")
    public String register(){
        return "register";
    }
	
	//logic to register user to DB etc
	
}
