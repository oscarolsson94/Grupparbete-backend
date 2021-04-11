package com.example.demo.service;
import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest {


    static private ToDoService toDoService;
    static private ToDoDao toDoDao;

    @BeforeAll
    static void initAll(){
        toDoService = Mockito.mock(ToDoService.class);
        toDoDao = Mockito.mock(ToDoDao.class);
    }

    @BeforeEach
    void init(){
        toDoService = new ToDoService(toDoDao);
    }


    @Test
    void addToDoToDatabase() {
        ToDo testToDo = setupTestObject();

        Mockito.when(toDoService.addToDoToDatabase(testToDo)).thenReturn(testToDo);
        assertEquals("task", toDoDao.addToDoToDatabase(testToDo).getTask());
        Mockito.verify(toDoDao).addToDoToDatabase(testToDo);
    }

    @Test
    void deleteById() {

        ToDo testToDo = setupTestObject();
        Mockito.when(toDoService.addToDoToDatabase(testToDo)).thenReturn(testToDo);

        toDoService.deleteById(1);
        Mockito.verify(toDoDao).deleteById(1);
    }

    @Test
    void allToDoByMail(){
        List<ToDo> expectedList = setupTestList();

        List<ToDo> unexpectedList = setupTestList();
        ToDo wrongTask = new ToDo("test");
        wrongTask.setEmail("wrong.lastname@mail.com");
        unexpectedList.add(wrongTask);

        Mockito.when(toDoService.allToDoByMail("firstname.lastname@mail.com")).thenReturn(expectedList);
        assertNotEquals(unexpectedList, toDoDao.allToDoByMail("firstname.lastname@mail.com"));
        Mockito.verify(toDoDao).allToDoByMail("firstname.lastname@mail.com");
    }

    private ToDo setupTestObject(){
        ToDo testToDo = new ToDo("task");
        testToDo.setEmail("firstname.lastname@mail.com");
        testToDo.setTaskID(1);
        return testToDo;
    }

    private List<ToDo> setupTestList(){
        List<ToDo> testList = new ArrayList<>();

        ToDo testToDo = new ToDo("test");
        testToDo.setEmail("firstname.lastname@mail.com");

        ToDo testToDo2 = new ToDo("test");
        testToDo2.setEmail("firstname.lastname@mail.com");

        testList.add(setupTestObject());
        testList.add(testToDo);
        testList.add(testToDo2);

        return testList;
    }
}