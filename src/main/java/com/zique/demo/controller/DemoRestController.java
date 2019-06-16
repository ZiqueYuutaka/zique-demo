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

import com.zique.demo.dto.Todo;
import com.zique.demo.service.DataService;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	@Autowired
	private DataService dataService;

	@GetMapping("/test")
	/**
	 * Test endpoint to verify connection and system is
	 * running.
	 * @return
	 */
	public String hello(){
		return "hello world";
	}
	
	@GetMapping("/todos")
	/**
	 * Returns all of the Todo items.
	 * @return
	 */
	public List<Todo> getAllTodos(){
		System.out.println(this.getClass().getName() + ": getting all todos.");
		
		ArrayList<Todo> todos = new ArrayList<>();
		
		todos = dataService.getAllTodos();
		
		return todos;
	}
	
	@GetMapping("/todos/{id}")
	public Todo getTodo(@PathVariable long id){
		return dataService.findById(id);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodoById( @PathVariable long id){
		System.out.println("Delete Todo with id " + id);
		
		Todo todo = dataService.deleteTodoById(id);
		if(todo!=null){
			System.out.println("deleted " + todo.toString());
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable long id,
						   @RequestBody Todo todo){
		System.out.println("===>>>Putting existing todo: " + todo);
		
		Todo updated = dataService.save(todo);
		
		return new ResponseEntity<Todo>(updated,HttpStatus.OK);
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
		System.out.println("===>>>Posting new todo: " + todo);
		
		Todo saved = dataService.save(todo);
		
		return new ResponseEntity<Todo>(saved,HttpStatus.CREATED);
	}
	
	
}
