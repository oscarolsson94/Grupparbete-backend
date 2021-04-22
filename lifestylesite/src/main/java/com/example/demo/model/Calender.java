package com.example.demo.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class Calender {

    private Integer dateId; //ID needs to be automatic
    private LocalDate date;
    private Event event;


    public Calender(Integer dateId, LocalDate date) {
        this.dateId = dateId;
        this.date = date;
    }

    public Calender(LocalDate date) {
        this.date = date;
    }

    public Calender(LocalDate date, Event event) {
        this.date = date;
        this.event = event;
    }

    public Calender(Integer dateId, LocalDate date, Event event) {
        this.dateId = dateId;
        this.date = date;
        this.event = event;
    }

    public Calender() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}


