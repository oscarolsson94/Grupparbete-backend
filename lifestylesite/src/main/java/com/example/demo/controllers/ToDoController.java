package com.example.demo.controllers;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/todo")
    public String toDo(Principal principal, Model model){
        model.addAttribute("todo", new ToDo());
        model.addAttribute("tasks", toDoRepository.findByEmail(principal.getName())); //findAllByEmail
        return "todo";
    }

    @PostMapping("/todo/addTask")
    public String addToDo(Principal principal, ToDo todo){
    	todo.setEmail(principal.getName());
        toDoRepository.save(todo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/deleteTask/{taskID}")
    public String deleteToDo(@PathVariable Integer taskID){
        toDoRepository.deleteById(taskID);
        return "redirect:/todo";
    }
}
