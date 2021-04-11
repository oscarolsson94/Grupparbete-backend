package com.example.demo.service;

import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest {


    private ToDoService toDoService;

    @BeforeEach
    void init(){
        toDoService = Mockito.mock(ToDoService.class);
    }


    @Test
    void addToDoToDatabase() {
        ToDo testToDo = setupTestObject();

        Mockito.when(toDoService.addToDoToDatabase(testToDo)).thenReturn(testToDo);
        assertEquals(testToDo, toDoService.addToDoToDatabase(testToDo));
    }

    @Test
    void deleteById() {
    }

    @Test
    void allToDoByMail() {
    }

    private ToDo setupTestObject(){
        ToDo testToDo = new ToDo("task");
        testToDo.setEmail("firstname.lastname@mail.com");
        testToDo.setTaskID(1);
        return testToDo;
    }
}