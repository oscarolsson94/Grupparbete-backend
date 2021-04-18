package com.example.demo.service;

import com.example.demo.dao.EventDAO;
import com.example.demo.dto.EventDTO;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Event> showEvents() {
        List<Event> eventList = new ArrayList<>();
        List<EventDTO> eventDTOSList = (List<EventDTO>) eventDAO.getAllEvents();
        for (EventDTO eventDTO : eventDTOSList){
            eventList.add(mapToEvent(eventDTO));
        }
        return eventList;
    }

    public EventDTO mapFromEvent(Event event){
        return new EventDTO(event.getDate(),event.getTime(),event.getName());
    }

    public Event mapToEvent(EventDTO eventDTO){
        return new Event(eventDTO.getId(),eventDTO.getDate(),eventDTO.getTime(),eventDTO.getEvent());
    }
}
