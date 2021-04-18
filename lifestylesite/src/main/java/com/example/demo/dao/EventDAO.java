package com.example.demo.dao;

import com.example.demo.dto.CalendarDTO;
import com.example.demo.dto.EventDTO;
import com.example.demo.repository.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO {

    private final EventRepository repository;

    public EventDAO(EventRepository repository) {
        this.repository = repository;
    }

    public Iterable<EventDTO> getAllEvents(){
        return repository.findAll();
    }

    public EventDTO addEvent(EventDTO eventDTO){
        return repository.save(eventDTO);
    }
}
