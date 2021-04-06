package com.example.demo.repository;

import com.example.demo.model.ToDo;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, ID> {
}
