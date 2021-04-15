package com.example.demo.service;
import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import org.junit.jupiter.api.Assertions;
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
        ToDo newObject = new ToDo("second test");

        Mockito.when(toDoService.addToDoToDatabase(testToDo)).thenReturn(testToDo);

        toDoService.addToDoToDatabase(newObject);

        assertNotEquals(testToDo, toDoService.addToDoToDatabase(newObject));
        assertEquals(testToDo, toDoService.addToDoToDatabase(testToDo));

    }

    @Test
    void deleteById() {

        toDoService.deleteById(1);
        Mockito.verify(toDoDao).deleteById(1);
    }

    @Test
    void allToDoByMail(){
        List<ToDo> expectedList = setupTestList();

        Mockito.when(toDoService.allToDoByMail("firstname.lastname@mail.com")).thenReturn(expectedList);

        assertFalse(expectedList.equals(toDoService.allToDoByMail("Unknown")));
    }

    @Test
    void getToDoByID(){
        ToDo testToDo = setupTestObject();
        ToDo testToDoTwo = setupTestObject();
        testToDoTwo.setTaskID(2);

        Mockito.when(toDoService.getToDoByID(1)).thenReturn(testToDo);

        Mockito.when(toDoService.getToDoByID(2)).thenReturn(testToDoTwo);

        assertEquals(1, toDoService.getToDoByID(1).getTaskID());
        assertEquals(testToDoTwo, toDoService.getToDoByID(2));
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