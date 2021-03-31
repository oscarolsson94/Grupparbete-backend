package com.example.demo.service;

import com.example.demo.dao.ToDoDAO;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoDAO toDoDAO;

    public ToDoService(ToDoDAO toDoDAO) {
        this.toDoDAO = toDoDAO;
    }
}
