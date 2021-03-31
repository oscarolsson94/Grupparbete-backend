package com.example.demo.dao;

import com.example.demo.repository.ToDoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoDAO {


    final ToDoRepository repository;

    public ToDoDAO(ToDoRepository repository) {
        this.repository = repository;
    }

    //I denna metod så sparar jag instansen av klassen ToDoDAO till databasen.
    public void addToDo(ToDoDAO toDoDAO){
        repository.save(toDoDAO);
    }
}
