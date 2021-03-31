package com.example.demo.repository;

import com.example.demo.dao.ToDoDAO;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepoistory extends CrudRepository<ToDoDAO, Integer> {
}
