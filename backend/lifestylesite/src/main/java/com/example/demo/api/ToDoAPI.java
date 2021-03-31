package com.example.demo.api;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoAPI {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/")
    public List<ToDo> getAllToDos(){
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList;
    }

}
