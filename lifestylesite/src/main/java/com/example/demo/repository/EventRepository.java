package com.example.demo.repository;

import com.example.demo.dto.EventDTO;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository <EventDTO, Integer> {
}
