package com.zique.demo.datasource;

import java.util.List;

import com.zique.demo.dto.Todo;

public interface TodoDao {
	
	public List<Todo> findAll();
	
	public Todo findById(long id);
	
	public Todo save(Todo todo);
	
	public Todo deleteById(long id);

}
