package com.example.demo.service;

import com.example.demo.dao.CalendarDAO;
import com.example.demo.dao.EventDAO;
import com.example.demo.dto.EventDTO;
import com.example.demo.model.Calender;
import com.example.demo.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EventListener;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalenderServiceTest {

    @Mock
    private CalendarDAO calendarDAO;
    private CalenderService underTestService;
    private EventDAO eventDAO;

    @BeforeEach
    void setUp() {
        underTestService = new CalenderService(calendarDAO , eventDAO);
    }


    @Test
    void saveEvents() {
        EventDTO eventDTOFromDatabase = new EventDTO(1,LocalDate.now(),LocalTime.now(),"happy!");
        Event expectedEvent = new Event(1,LocalDate.now(),LocalTime.now(),"happy!");

        Mockito.when(eventDAO.addEvent(ArgumentMatchers.any(EventDTO.class))).thenReturn(eventDTOFromDatabase);
        Event createdEvent = underTestService.saveEvents(expectedEvent);

        assertThat(expectedEvent.getName()).isEqualTo(createdEvent.getName());
    }

    private EventDTO mapFromEvent(Event event){
        return new EventDTO(event.getDate(),event.getTime(),event.getName());
    }

    private Event mapToEvent(EventDTO eventDTO){
        return new Event(eventDTO.getId(),eventDTO.getDate(),eventDTO.getTime(),eventDTO.getEvent());
    }
}