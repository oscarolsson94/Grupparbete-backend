package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start {

    @GetMapping("/")
    public String start(){
        return "start";
    }
    
    @GetMapping("/calendar")
    public String calendar(){
        return "calendar";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/todo")
    public String toDo(){
        return "todo";
    }
}
