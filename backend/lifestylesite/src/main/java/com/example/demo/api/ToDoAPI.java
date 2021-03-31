package com.example.demo.api;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoAPI {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/get-tasks")
    public List<ToDo> getAllToDos(){
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList;
    }

    @PostMapping("/create-tasks")
    public ToDo createTask(@RequestBody ToDo todo){
        ToDo task = toDoRepository.save(todo);
        return task;
    }

}
