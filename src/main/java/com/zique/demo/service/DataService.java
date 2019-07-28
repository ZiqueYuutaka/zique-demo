package com.zique.demo.service;
import java.util.List;

import com.zique.demo.dto.Todo;

public interface DataService {

	public List<Todo> getAllTodos();
	
	public Todo deleteTodoById(long todoId);
	
	public Todo save(Todo todo);
	
	public Todo findById(long id);
}
