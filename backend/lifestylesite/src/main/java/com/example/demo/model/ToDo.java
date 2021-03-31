package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String task;
    private boolean taskStatus = false;

    public ToDo(int taskID, String task) {
        this.taskID = taskID;
        this.task = task;
    }

    public ToDo() {

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
