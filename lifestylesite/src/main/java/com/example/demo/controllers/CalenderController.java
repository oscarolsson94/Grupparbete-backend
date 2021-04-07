package com.example.demo.controllers;

import com.example.demo.model.Calender;
import com.example.demo.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="calendar/list") //Change to calender site when ready with thymeleaf
public class CalenderController {

    private final CalenderService calenderService;

    @Autowired
    public CalenderController(CalenderService calenderService){
        this.calenderService = calenderService;
    }


    @GetMapping
    public List<Calender> getCalender(){
          return calenderService.getAllCalenders();
    }
}
