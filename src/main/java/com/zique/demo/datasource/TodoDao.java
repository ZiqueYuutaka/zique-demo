package com.zique.demo.datasource;

import java.util.List;

import com.zique.demo.dto.Todo;

public interface TodoDao {
	
	public List<Todo> findAll();
	
	public Todo findById(int id);
	
	public Todo save(Todo employee);
	
	public String deleteById(int id);

}
