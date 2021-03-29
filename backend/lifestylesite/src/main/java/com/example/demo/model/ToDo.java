package com.example.demo.model;

public class ToDo {

    private int taskID;
    private String task;
    private boolean taskStatus = false;

    public ToDo(int taskID, String task) {
        this.taskID = taskID;
        this.task = task;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID){
        this.taskID = taskID;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }
}
