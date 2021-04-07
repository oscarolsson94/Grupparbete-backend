package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String task;
    private String email;

	public ToDo(String task) {
    	super();
        this.task = task;
    }

    public ToDo() {

    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
