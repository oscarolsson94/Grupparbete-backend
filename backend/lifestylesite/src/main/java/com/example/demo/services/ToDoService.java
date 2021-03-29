package com.example.demo.services;

import com.example.demo.model.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    public List<ToDo> getToDos(){
        List<ToDo> toDos = new ArrayList<>();

        toDos.add(new ToDo(1, "Jag vill plugga."));
        toDos.add(new ToDo(2,"Jag vill spela fotboll."));

        return toDos;
    }



}
