package com.example.demo.service;

import com.example.demo.dao.EventDAO;
import com.example.demo.dto.EventDTO;
import com.example.demo.repository.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventDAO eventDAO;
    private EventService underTest;

    @BeforeEach
    void setUp(){
        underTest = new EventService(eventDAO);
    }



    @Test
    void deleteEventById() {
        EventDTO testClass = new EventDTO( LocalDate.now(), LocalTime.now(),"test");
        testClass.setId(1);
        eventDAO.addEventToDatabase(testClass);
        //then
        underTest.deleteById(1);
        verify(eventDAO).deleteEventById(1);
    }

    @Test
    void GetAllEventsFromDatabase() {
    //when
        EventDTO testClass = new EventDTO( LocalDate.now(), LocalTime.now(),"test");
        testClass.setId(1);
        eventDAO.addEventToDatabase(testClass);
        underTest.showEvents();
        //then
        verify(eventDAO).getAllEvents();
    }

    @Test
    void getEventById() {
        EventDTO eventDTOFromDatabase = new EventDTO(1,LocalDate.now(),LocalTime.now(),"happy!");
        EventDTO expectedEvent = new EventDTO(1,LocalDate.now(),LocalTime.now(),"happy!");

        Mockito.when(eventDAO.findEventById(1)).thenReturn(Optional.of(eventDTOFromDatabase));
        EventDTO actualEvent = underTest.getEventById(1);

        assertThat(actualEvent.getId()).isEqualTo(expectedEvent.getId());

    }


    @Test
    void addEventToDatabase() {
        //when
        EventDTO eventDTOFromDatabase = new EventDTO(1,LocalDate.now(),LocalTime.now(),"happy!");
        underTest.addEventToDatabase(eventDTOFromDatabase);
        //then
        verify(eventDAO).addEventToDatabase(eventDTOFromDatabase);
    }
}