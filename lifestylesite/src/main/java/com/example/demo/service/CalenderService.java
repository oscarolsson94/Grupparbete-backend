package com.example.demo.service;

import com.example.demo.model.Calender;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalenderService {

    public List<Calender> getAllCalenders() {

        Calender today = new Calender(LocalDate.now());
        LocalDate temp = today.getDate();
        List<Calender> calendars = new ArrayList<>();

        for(int i =0;i < 32;i++){// Change from 31 days when connected to a database
            temp = today.getDate().plusDays(i);
            Calender todayPlusI = new Calender(temp);
            calendars.add(todayPlusI);
        }
        return calendars;
    }


}
