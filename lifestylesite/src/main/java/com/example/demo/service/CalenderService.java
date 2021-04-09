package com.example.demo.service;

import com.example.demo.dao.CalendarDAO;
import com.example.demo.dto.CalendarDTO;
import com.example.demo.model.Calender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalenderService {

        private final CalendarDAO calendarDAO;

    public CalenderService(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }

    public List<Calender> initializeCalenders() {

        Calender today = new Calender(LocalDate.now());
        LocalDate temp = today.getDate();
        List<Calender> calendars = new ArrayList<>();
        List<CalendarDTO> calendarDTOS = new ArrayList<>();

        for(int i =0;i < 32;i++){// Change from 31 days when connected to a database
            temp = today.getDate().plusDays(i);
            Calender todayPlusI = new Calender(temp);
            calendars.add(todayPlusI);
        }

        for (Calender calendar : calendars) {
           calendarDTOS.add(calendarDAO.addCalendar(mapFromCalendar(calendar)));
        }

        for (int x = 0;x<calendars.size();x++){
            calendars.get(x).setDateId(calendarDTOS.get(x).getId());
        }
        return calendars;
    }

    public Calender mapToCalendar(CalendarDTO calendarDTO){
        return new Calender(calendarDTO.getId(), calendarDTO.getDate());
    }

    public CalendarDTO mapFromCalendar(Calender calender){
        return new CalendarDTO(calender.getDateId(),calender.getDate());
    }


}
