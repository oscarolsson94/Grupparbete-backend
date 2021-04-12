package com.example.demo.controllers;

import com.example.demo.model.ToDo;
import java.security.Principal;
import com.example.demo.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    final
    ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public String toDo(Principal principal, Model model){
        model.addAttribute("todo", new ToDo());
        model.addAttribute("tasks", toDoService.allToDoByMail(principal.getName())); //findAllByEmail
        return "todo";
    }

    @PostMapping("/todo/addTask")
    public String addToDo(Principal principal, ToDo todo){
    	todo.setEmail(principal.getName());
        toDoService.addToDoToDatabase(todo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/deleteTask/{taskID}")
    public String deleteToDo(@PathVariable Integer taskID){
        toDoService.deleteById(taskID);
        return "redirect:/todo";
    }
}
