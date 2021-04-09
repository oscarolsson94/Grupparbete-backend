package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    public void addToDoToDatabase(ToDo todo){
        toDoRepository.save(todo);
    }
}
