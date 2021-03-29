package com.example.demo.model;

public class ToDo {

    private String task;
    private boolean taskStatus = false;

    public ToDo(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }
}
