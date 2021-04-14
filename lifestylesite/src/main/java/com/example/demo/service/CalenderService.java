package com.example.demo.service;

import com.example.demo.dao.CalendarDAO;
import com.example.demo.dto.CalendarDTO;
import com.example.demo.model.Calender;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
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
        calendarDAO.deleteAll(); //restart calendar
        Calender today = new Calender(retunMonthOfToday());
        LocalDate tempFowards;
        List<Calender> calendars = new ArrayList<>();
        List<CalendarDTO> calendarDTOS = new ArrayList<>();
        List<Calender> empty = new ArrayList<>();

            //Creates 35 dates from the date today
            for(int i =0;i <35;i++){
                tempFowards = today.getDate().plusDays(i);
                Calender todayPlusI = new Calender(tempFowards);
                calendars.add(todayPlusI);

            }
            // Adds to Database
            for (Calender calendar : calendars) {
                calendarDTOS.add(calendarDAO.addCalendar(mapFromCalendar(calendar)));
            }
            //here set id as the same id in the database
            for (int x = 0;x<calendars.size();x++){
                calendars.get(x).setDateId(calendarDTOS.get(x).getId());
            }
            return calendars;

    }

    public int returnMonth(){


        LocalDate getMonth = LocalDate.now();
        return getMonth.getMonthValue();
    }

    public LocalDate retunMonthOfToday(){
        int MonthValue = returnMonth();
        List<Calender> completeShowList = new ArrayList<>();
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.MONDAY){
            return LocalDate.now();
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.TUESDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(1);
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(2);
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.THURSDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(3);
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.FRIDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(4);
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.SATURDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(5);
        }
        if (LocalDate.of(2020,MonthValue,1).getDayOfWeek() == DayOfWeek.SUNDAY){
            return LocalDate.of(2020,MonthValue,1).minusDays(6);
        }
        return null;
    }

    public Calender mapToCalendar(CalendarDTO calendarDTO){
        return new Calender(calendarDTO.getId(), calendarDTO.getDate());
    }

    public CalendarDTO mapFromCalendar(Calender calender){
        return new CalendarDTO(calender.getDateId(),calender.getDate());
    }


  /*  public Object findAll() {
        return calendarDAO.getAllCalendar();
    }
*/

}
