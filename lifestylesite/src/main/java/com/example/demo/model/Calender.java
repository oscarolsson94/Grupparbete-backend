package com.example.demo.model;

import java.time.LocalDate;

public class Calender {

    private Integer dateId; //ID needs to be automatic
    private LocalDate date;

    public Calender(Integer dateId, LocalDate date) {
        this.dateId = dateId;
        this.date = date;
    }

    public Calender(LocalDate date) {
        this.date = date;
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
}
