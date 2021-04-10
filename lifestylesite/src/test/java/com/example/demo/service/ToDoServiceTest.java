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

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest {

    @Mock
    private ToDoDao toDoDao;

    @Autowired
    private ToDoService toDoService;

    @BeforeEach
    void init(){
        toDoDao = Mockito.mock(ToDoDao.class);
        toDoService = Mockito.mock(ToDoService.class);
    }


    @Test
    void addToDoToDatabase() {
        ToDo testToDo = new ToDo("task");
        testToDo.setEmail("firstname.lastname@mail.com");

        Mockito.when(toDoDao.addToDoToDatabase(testToDo)).thenReturn(testToDo);
        assertEquals(testToDo, null);
    }

    @Test
    void deleteById() {
    }

    @Test
    void allToDoByMail() {
    }
}