package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> filterTaskByEmail(String email){
        List<ToDo> allTasks = toDoRepository.findAll();

        List<ToDo> filteredTasks = new ArrayList<>();

        for(ToDo task : allTasks){
            if(task.getEmail().equals(email)){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}
