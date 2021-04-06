package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String task;

    public ToDo(String task) {
        this.task = task;
    }

    public ToDo() {

    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
