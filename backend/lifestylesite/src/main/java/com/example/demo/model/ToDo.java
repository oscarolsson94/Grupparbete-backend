package com.example.demo.model;

public class ToDo {

    private int taskID;
    private String task;
    private boolean taskStatus = false;

    public ToDo(int taskID, String task) {
        this.taskID = taskID;
        Task = task;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTask() {
        return task;
    }
}
