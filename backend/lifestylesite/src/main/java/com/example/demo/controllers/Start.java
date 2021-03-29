package com.example.demo.controllers;

import com.example.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/start")
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
    
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/todo")
    public String toDo(Model model){
        model.addAttribute("todo", toDoService.getToDoStrings());
        return "todo";
    }
}
