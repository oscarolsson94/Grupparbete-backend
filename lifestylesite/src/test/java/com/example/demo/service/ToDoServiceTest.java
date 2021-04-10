package com.example.demo.service;

import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest {

    static ToDoDao toDoDao;

    @BeforeAll
    public static void start(){
        toDoDao = Mockito.mock(ToDoDao.class);
        //Here we set up an "fake" version of the dao class,
        //This means we can throw certain tests at the database without it actually running.
    }

    @Test
    void addToDoToDatabase() {

    }



    @Test
    void deleteById() {
    }

    @Test
    void allToDoByMail() {
    }
}