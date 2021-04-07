package com.example.demo.model;

import java.time.LocalDate;
import java.util.UUID;

public class Calender {

    private UUID dateId; //ID needs to be automatic
    private LocalDate date;

    public Calender(UUID dateId, LocalDate date) {
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

    public UUID getDateId() {
        return dateId;
    }

    public void setDateId(UUID dateId) {
        this.dateId = dateId;
    }
}
