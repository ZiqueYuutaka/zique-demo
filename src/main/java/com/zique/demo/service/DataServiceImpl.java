package com.zique.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zique.demo.datasource.TodoDao;
import com.zique.demo.dto.Todo;

@Service
public class DataServiceImpl implements DataService {

	//@Autowired
	//private DataBase database;
	
	@Autowired
	private TodoDao todoDao;
	
	public DataServiceImpl(@Qualifier("todoDaoHibernateImpl")TodoDao todoDao){
		this.todoDao = todoDao;
	}

	@Override
	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return todoDao.findAll();
	}
	
	@Override
	public Todo deleteTodoById(long todoId){
		Todo todo = todoDao.deleteById(todoId);
		System.out.println("todo deleted: " + todo);
		return todo;
	}

	@Override
	public Todo findById(long id) {
		Todo todo = todoDao.findById(id);
		System.out.println("todo found: " + todo);
		return todo;
	}

	@Override
	public Todo save(Todo todo) {
		todo = todoDao.save(todo);
		System.out.println("saved todo: " + todo);
		return todo;
	}
	
	

}
