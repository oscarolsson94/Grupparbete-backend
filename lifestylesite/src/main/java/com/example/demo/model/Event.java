package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event extends Calender{

    private LocalTime time;
    private String Name;

    public Event(Integer dateId, LocalDate date) {
        super(dateId, date);
    }

    public Event(LocalDate date) {
        super(date);
    }

    public Event(Integer dateId, LocalDate date, LocalTime time, String name) {
        super(dateId, date);
        this.time = time;
        this.Name = name;
    }

    public Event( LocalTime time, String name) {
        this.time = time;
        this.Name = name;
    }

    public Event() {
        super();
    }



    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
