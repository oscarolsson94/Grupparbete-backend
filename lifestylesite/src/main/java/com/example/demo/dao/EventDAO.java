package com.example.demo.dao;

import com.example.demo.dto.EventDTO;
import com.example.demo.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    public Optional<EventDTO> findEventById(Integer Id){

        return repository.findById(Id);
    }

    public void deleteEventById(Integer id) {
        repository.deleteById(id);
    }

    public EventDTO addEventToDatabase(EventDTO updateEvent) {
        return repository.save(updateEvent);
    }
}
