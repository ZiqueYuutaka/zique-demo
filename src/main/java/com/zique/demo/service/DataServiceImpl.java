package com.zique.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zique.demo.datasource.DataBase;
import com.zique.demo.dto.Todo;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataBase database;

	@Override
	public ArrayList<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return database.getAllTodos();
	}
	
	@Override
	public Todo deleteTodoById(long todoId){
		Todo todo = database.deleteTodoById(todoId);
		System.out.println("todo deleted: " + todo);
		return todo;
	}

	@Override
	public Todo findById(long id) {
		Todo todo = database.findById(id);
		System.out.println("todo found: " + todo);
		return todo;
	}

	@Override
	public Todo save(Todo todo) {
		todo = database.saveTodo(todo);
		System.out.println("saved todo: " + todo);
		return todo;
	}
	
	

}
