package com.example.demo.service;

import com.example.demo.dao.CalendarDAO;
import com.example.demo.dao.EventDAO;
import com.example.demo.dto.CalendarDTO;
import com.example.demo.dto.EventDTO;
import com.example.demo.model.Calender;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalenderService {

        private final CalendarDAO calendarDAO;
        private final EventDAO eventDAO;

    public CalenderService(CalendarDAO calendarDAO, EventDAO eventDAO) {
        this.calendarDAO = calendarDAO;
        this.eventDAO = eventDAO;
    }



    public List<Calender> initializeCalenders() {
        List <Event> EventList = crossCheckEventAndCalender();
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


                return restructureCalendarsWithEvents(calendars, EventList);


    }

    private List<Calender> restructureCalendarsWithEvents(List<Calender> calenderList, List<Event> eventList) {

        for (Event event : eventList) {
            for (Calender calender : calenderList) {
                if (calender.getDate().equals(event.getDate())) {
                    calender.setEvent(new Event(event.getTime(), event.getName()));
                }else{
                    calender.setEvent(new Event(LocalTime.now(), "empty"));
                }
            }
        }

        return calenderList;
    }

    private List<Event> crossCheckEventAndCalender(){
        List <Event> eventList = new ArrayList<>();
        List <CalendarDTO> calendarDTOSList = (List<CalendarDTO>) calendarDAO.getAllCalendar();
        List <EventDTO> EventDTOSList = (List<EventDTO>) eventDAO.getAllEvents();

            for (EventDTO eventDTO : EventDTOSList) {
                for (CalendarDTO calendarDTO : calendarDTOSList) {
                    if (calendarDTO.getDate().equals(eventDTO.getDate())) {
                        eventList.add(new Event(calendarDTO.getId(), calendarDTO.getDate(), eventDTO.getTime(), eventDTO.getEvent()));
                    }
                }
            }

         return eventList;
    }

    private int returnMonth(){


        LocalDate getMonth = LocalDate.now();
        return getMonth.getMonthValue();
    }

    private LocalDate retunMonthOfToday(){
        int MonthValue = returnMonth();
        List<Calender> completeShowList = new ArrayList<>();
        if (LocalDate.of(LocalDate.now().getYear(), MonthValue,1).getDayOfWeek() == DayOfWeek.MONDAY){
            return LocalDate.now();
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.TUESDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(1);
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(2);
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.THURSDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(3);
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.FRIDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(4);
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.SATURDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(5);
        }
        if (LocalDate.of(LocalDate.now().getYear(),MonthValue,1).getDayOfWeek() == DayOfWeek.SUNDAY){
            return LocalDate.of(LocalDate.now().getYear(),MonthValue,1).minusDays(6);
        }
        return null;
    }

    private Calender mapToCalendar(CalendarDTO calendarDTO){
        return new Calender(calendarDTO.getId(), calendarDTO.getDate());
    }

    private CalendarDTO mapFromCalendar(Calender calender){

        return new CalendarDTO(calender.getDateId(),calender.getDate());
    }

    private EventDTO mapFromEvent(Event event){
        return new EventDTO(event.getDate(),event.getTime(),event.getName());
    }


    public Event saveEvents(Event event){

        eventDAO.addEvent(mapFromEvent(event));
        return event;

    }


}
