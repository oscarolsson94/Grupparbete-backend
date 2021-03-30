package com.example.demo.service;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService { // extend needed for spring security

	User save(UserRegisterDto registrationDto); //declare method that will save data
}
