package com.example.demo.repository;

import com.example.demo.model.ToDo;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
	List<ToDo> findByEmail(String email);
}
