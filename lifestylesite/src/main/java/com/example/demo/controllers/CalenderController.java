package com.example.demo.controllers;

import com.example.demo.model.Calender;
import com.example.demo.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalenderController {

    private final CalenderService calenderService;

    @Autowired
    public CalenderController(CalenderService calenderService){
        this.calenderService = calenderService;
    }


    @RequestMapping("calendar")
    public String getCalender(Model model){
       model.addAttribute("calendarslist", calenderService.initializeCalenders());
       model.addAttribute("calendar", new Calender(LocalDate.now()));
          return "calendar";
    }

}
