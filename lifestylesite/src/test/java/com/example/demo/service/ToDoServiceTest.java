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
        toDoDao = Mockito.mock(ToDoDao.class);
    }

    @BeforeEach
    void init(){
        toDoService = new ToDoService(toDoDao);
    }


    @Test
    void addToDoToDatabase() {
        ToDo testToDo = setupTestObject();

        Mockito.when(toDoDao.addToDoToDatabase(testToDo)).thenReturn(testToDo);

        ToDo newToDo = toDoService.addToDoToDatabase(testToDo);

        assertEquals(newToDo, toDoService.addToDoToDatabase(testToDo));

    }

    @Test
    void deleteById() {

        toDoService.deleteById(1);
        Mockito.verify(toDoDao, Mockito.times(1)).deleteById(1);
    }

    @Test
    void allToDoByMail(){
        List<ToDo> testList = setupTestList();

        Mockito.when(toDoDao.allToDoByMail("firstname.lastname@mail.com")).thenReturn(testList);

        List<ToDo> results2 = toDoService.allToDoByMail("firstname.lastname@mail.com");

        assertEquals(results2, testList);
        assertNotEquals(results2, toDoService.allToDoByMail("wrong.lastname@mail.com"));


    }

    @Test
    void getToDoByID(){
        ToDo testToDo = setupTestObject();
        ToDo testToDoTwo = setupTestObject();
        testToDoTwo.setTaskID(2);

        Mockito.when(toDoDao.getToDoByID(1)).thenReturn(testToDo);

        ToDo resultToDo = toDoService.getToDoByID(1);

        assertEquals(1, resultToDo.getTaskID());
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

        ToDo testToDo3 = new ToDo("test");
        testToDo2.setEmail("wrong.lastname@mail.com");

        testList.add(setupTestObject());
        testList.add(testToDo);
        testList.add(testToDo2);
        testList.add(testToDo3);

        return testList;
    }
}