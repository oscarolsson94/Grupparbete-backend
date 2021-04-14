package com.example.demo.dao;


import com.example.demo.dto.CalendarDTO;
import com.example.demo.repository.CalendarRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CalendarDAO {

    private final CalendarRepository repository;


    public CalendarDAO(CalendarRepository repository) {
        this.repository = repository;
    }

    public CalendarDTO addCalendar(CalendarDTO calendarDTO){
        return repository.save(calendarDTO);
    }

    public Iterable<CalendarDTO> getAllCalendar(){
        return repository.findAll();
    }

    public boolean checkIfEmpty(){
        return !repository.existsById(1);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
