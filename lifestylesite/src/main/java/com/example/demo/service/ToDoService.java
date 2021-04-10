package com.example.demo.service;
import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class ToDoService {

    final
    ToDoDao toDoDao;

    ToDoRepository toDoRepository;

    public ToDoService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public ToDo addToDoToDatabase(ToDo todo){
        return toDoDao.addToDoToDatabase(todo);
    }

    public void deleteById(Integer id){
        toDoDao.deleteById(id);
    }

    public List<ToDo> allToDoByMail(Principal principal){
        List<ToDo> allTasks = toDoDao.allToDoByMail(principal);
        return allTasks;
    }
}
