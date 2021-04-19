package com.example.demo.controllers;

import com.example.demo.dto.EventDTO;
import com.example.demo.model.Calender;
import com.example.demo.model.Event;
import com.example.demo.service.CalenderService;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class CalenderController {

    private final CalenderService calenderService;
    private final EventService eventService;

    @Autowired
    public CalenderController(CalenderService calenderService, EventService eventService){
        this.calenderService = calenderService;
        this.eventService = eventService;
    }


    @RequestMapping("calendar")
    public String getCalender(Model model){
       model.addAttribute("calendarslist", calenderService.initializeCalenders());
       model.addAttribute("calendar", new Calender(LocalDate.now()));
       model.addAttribute("event", new Event());
       model.addAttribute("eventList", eventService.showEvents());
          return "calendar";
    }

    @GetMapping("/calendar/GET")
    public String refreshPage(Model model){
        model.addAttribute("calendarslist", calenderService.initializeCalenders());
        model.addAttribute("calendar", new Calender(LocalDate.now()));
        model.addAttribute("event", new Event());
        return "redirect:/calendar";
    }

    @PostMapping("/calendar/POST")
    public String addEvent(Event event, Model model){
        calenderService.saveEvents(event);

        return "redirect:/calendar";
    }

    @PostMapping("/calendar/deleteEvent/{eventID}")
    public String deleteEvent(@PathVariable Integer eventID){
        eventService.deleteById(eventID);
        return "redirect:/calendar";
    }

    @PutMapping("/calendar/editEvent/{eventId}")
        public String editEvent(@PathVariable Integer eventId, @RequestParam String event){
        EventDTO updateEvent = eventService.getEventById(eventId);
        updateEvent.setEvent(event);
        eventService.addEventToDatabase(updateEvent);
        return "redirect:/calendar";
        }
}
