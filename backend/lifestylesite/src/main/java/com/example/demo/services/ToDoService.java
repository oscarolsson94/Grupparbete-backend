package com.example.demo.services;

import com.example.demo.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    public List<ToDo> getToDoStrings(){
        List<ToDo> toDos = new ArrayList<>();

        toDos.add(new ToDo("Jag vill plugga."));
        toDos.add(new ToDo("Jag vill spela fotboll."));

        return toDos;
    }



}
