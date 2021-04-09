package com.example.demo.service;
import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class ToDoService {

    final
    ToDoDao toDoDao;

    public ToDoService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public void addToDoToDatabase(ToDo todo){
        toDoDao.addToDoToDatabase(todo);
    }

    public void deleteById(Integer id){
        toDoDao.deleteById(id);
    }

    public List<ToDo> allToDoByMail(Principal principal){
        List<ToDo> allTasks = toDoDao.allToDoByMail(principal);
        return allTasks;
    }
}
