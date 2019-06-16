package com.zique.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zique.demo.dto.HelloBean;
import com.zique.demo.dto.Todo;
import com.zique.demo.service.DataService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	@Autowired
	private DataService dataService;

	@GetMapping("/test")
	public String hello(){
		return "hello world";
	}
	
	@GetMapping("/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName){
		System.out.println(this.getClass().getName() + ": getting all todos for  "+userName+"...");
		
		ArrayList<Todo> todos = new ArrayList<>();
		
		todos = dataService.getAllTodos(userName);
		
		return todos;
	}
	
	@GetMapping("/users/{userName}/todos/{id}")
	public Todo getTodo(@PathVariable String userName, @PathVariable long id){
		return dataService.findById(id);
	}
	
	@DeleteMapping("/users/{userName}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String userName, @PathVariable long todoId){
		System.out.println("Delete Todo with id " + todoId);
		
		Todo todo = dataService.deleteTodoById(todoId);
		if(todo!=null){
			System.out.println("deleted " + todo.toString());
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @PathVariable long id,
						   @RequestBody Todo todo){
		System.out.println("===>>>Putting existing todo: " + todo);
		
		Todo updated = dataService.save(todo);
		
		return new ResponseEntity<Todo>(updated,HttpStatus.OK);
	}
	
	@PostMapping("/users/{userName}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String userName, @RequestBody Todo todo){
		System.out.println("===>>>Posting new todo: " + todo);
		
		Todo saved = dataService.save(todo);
		
		return new ResponseEntity<Todo>(saved,HttpStatus.CREATED);
	}
	
	
}
