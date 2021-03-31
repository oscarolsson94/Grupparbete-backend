package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private UserService userService;

	public RegisterController(UserService userService) { //constructor based injection. Can also use @Autowired 
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")     //the form data will be saved in the user object
	public UserRegisterDto userRegisterDto() {
		return new UserRegisterDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDto registerDto) {
		userService.save(registerDto);
		return "redirect:/register?success"; //return registration view with success message
	}
	
	
}

