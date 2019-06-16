package com.zique.demo.datasource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.zique.demo.dto.Todo;

/**
 * Demo database. To be modified once actual database implemented.
 * @author Zique Yuutaka
 *
 */
@Repository
public class DataBase {
	
	public static final String DATE_PATTERN = "yyyy/MM/dd";
	ArrayList<Todo> todos;
	private long idCounter;
	
	public DataBase(){
		//SimpleDateFormat formatter = new SimpleDateFormat(datePattern);

		todos = new ArrayList<>();
		todos.add(new Todo(1, "Todo 1 from back end" , "complete", new Date()));
		todos.add(new Todo(2, "Todo 2 from back end" , "pending", new Date()));
		todos.add(new Todo(3, "Todo 3 from back end" , "not started", new Date()));
		
		idCounter = todos.size();
	}
	
	public ArrayList<Todo> getAllTodos(){
		return todos;
	}
	
	public Todo deleteTodoById(long todoId){
		Todo temp;
		
		if(todos == null){
			return null; //empty list
		}
		
		temp = findById(todoId);
		
		if(temp!=null){
			todos.remove(temp);
		}
		return temp;
		
	}
	
	public Todo findById(long id){
		
		for(Todo todo: todos){
			if(todo.getId()==id){
				return todo;
			}
		}
		
		return null; // none found
	}
	
	/**
	 * Create a new object as long as id is set to
	 * -1 or 0. Otherwise, expect to update an existing
	 * object.
	 * @param todo
	 * @return
	 */
	public Todo saveTodo(Todo todo){
		if(todo.getId()==-1 || todo.getId()==0){
			todo.setId(++idCounter);
			todos.add(todo);
		}else{
			deleteTodoById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
