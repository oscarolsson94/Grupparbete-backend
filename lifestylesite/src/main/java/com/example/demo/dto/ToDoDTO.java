package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class ToDoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;
    private String email;
    private String task;

	public ToDoDTO(String task) {
    	super();
        this.task = task;
    }

    public ToDoDTO() {

    }
    public String getEmail(){
	    return this.email;
    }

	public void setEmail(String email) {
		this.email = email;
	}
    
    public Integer getTaskID() {
        return this.taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task){
	    this.task = task;
    }

}
