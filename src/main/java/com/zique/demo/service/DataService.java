package com.zique.demo.service;
import java.util.ArrayList;

import com.zique.demo.dto.Todo;

public interface DataService {

	public ArrayList<Todo> getAllTodos(String userName);
	
	public Todo deleteTodoById(long todoId);
	
	public Todo save(Todo todo);
	
	public Todo findById(long id);
}
