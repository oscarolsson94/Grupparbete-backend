package com.example.demo.dto;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Event")
public class EventDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private String event;

    public EventDTO(Integer id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public EventDTO() {
    }

    public EventDTO(LocalDate date, LocalTime time, String event) {
        this.date = date;
        this.time = time;
        this.event = event;
    }

    public EventDTO(Integer id, LocalDate date, LocalTime time, String event) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.event = event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
