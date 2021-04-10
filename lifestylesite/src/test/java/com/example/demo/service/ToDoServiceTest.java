package com.example.demo.service;

import com.example.demo.dao.ToDoDao;
import com.example.demo.model.ToDo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest {

    @Mock
    private ToDoDao toDoDao;


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