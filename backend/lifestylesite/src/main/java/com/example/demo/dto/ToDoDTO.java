package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class ToDoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String task;

    public ToDoDTO() {
    }

    public Integer getTaskID() {
        return taskID;
    }

    public String getTask() {
        return task;
    }
}
