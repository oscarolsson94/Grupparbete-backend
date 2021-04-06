package com.example.demo.controllers;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/todo")
    public String toDo(Model model){
        model.addAttribute("todo", new ToDo());
        model.addAttribute("tasks", toDoRepository.findAll());
        return "todo";
    }
}
