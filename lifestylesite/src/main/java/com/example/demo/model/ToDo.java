package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String email;
    private String task;

    public ToDo(String email, String task) {
    	super();
    	this.email = email;
        this.task = task;
    }

    public ToDo() {

    }

    public Integer getTaskID() {
        return this.taskID;
    }

    public String getEmail(){
        return this.email;
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
