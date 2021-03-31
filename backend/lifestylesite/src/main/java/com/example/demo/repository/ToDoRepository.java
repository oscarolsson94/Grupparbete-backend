package com.example.demo.repository;
import com.example.demo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
