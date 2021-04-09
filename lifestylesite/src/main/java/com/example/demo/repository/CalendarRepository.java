package com.example.demo.repository;


import com.example.demo.dto.CalendarDTO;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<CalendarDTO, Integer> {
}
