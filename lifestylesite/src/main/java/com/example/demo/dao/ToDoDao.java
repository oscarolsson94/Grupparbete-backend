package com.example.demo.dao;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

@Repository
public class ToDoDao {

    final
    ToDoRepository toDoRepository;

    public ToDoDao(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo addToDoToDatabase(ToDo todo){
        return toDoRepository.save(todo);
    }

    public void deleteById(Integer taskID){
        toDoRepository.deleteById(taskID);
    }

    public List<ToDo> allToDoTasks(){
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList;
    }

    public List<ToDo> allToDoByMail(Principal principal){
        List<ToDo> allToDos = toDoRepository.findByEmail(principal.getName());
        return allToDos;
    }
}
