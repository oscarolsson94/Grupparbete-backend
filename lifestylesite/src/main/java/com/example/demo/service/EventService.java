package com.example.demo.service;

import com.example.demo.dao.EventDAO;
import com.example.demo.dto.EventDTO;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void deleteById(Integer eventID) {
      eventDAO.deleteEventById(eventID);
    }

    public List<EventDTO> showEvents() {
        List<Event> eventList = new ArrayList<>();
        return (List<EventDTO>) eventDAO.getAllEvents();
    }


    public EventDTO getEventById(Integer eventId) {
            boolean existEvent = eventDAO.findEventById(eventId).isPresent();
        if (existEvent){
            return eventDAO.findEventById(eventId).get();
        } else{
            return null;
        }

    }

    public EventDTO addEventToDatabase(EventDTO updateEvent) {
        return eventDAO.addEventToDatabase(updateEvent);
    }

    private EventDTO mapFromEvent(Event event){
        return new EventDTO(event.getDate(),event.getTime(),event.getName());
    }

    private Event mapToEvent(EventDTO eventDTO){
        return new Event(eventDTO.getId(),eventDTO.getDate(),eventDTO.getTime(),eventDTO.getEvent());
    }


}
