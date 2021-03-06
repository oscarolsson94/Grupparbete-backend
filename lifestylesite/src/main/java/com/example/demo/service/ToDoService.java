package com.example.demo.service;
import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ToDoService {

    final
    ToDoDao toDoDao;

    public ToDoService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public ToDo addToDoToDatabase(ToDo todo){
        return toDoDao.addToDoToDatabase(todo);
    }

    public void deleteById(Integer id){
        toDoDao.deleteById(id);
    }

    public List<ToDo> allToDoByMail(String email){
        List<ToDo> allTasks = toDoDao.allToDoByMail(email);
        return allTasks;
    }

    public ToDo getToDoByID(Integer ID){
        return toDoDao.getToDoByID(ID);
    }

}
