package Todo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import Todo.model.Todo;
import Todo.service.TodoService;
import Todo.service.UserService;



@RestController
@RequestMapping(value="/Todos", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
	@Autowired
	private TodoService todoService;
	@Autowired
	private UserService userService;
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") long todoId){
		return new ResponseEntity<Todo>(todoService.getTodoById(todoId),HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
	public List<Todo> getTodoByuser(@PathVariable("id") long userId){
		return userService.gettodosByUser(userId);
	}
	@PostMapping()
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
		
		return new ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable (value = "id") long id, @RequestBody Todo todo) {
		
		return new ResponseEntity<Todo>(todoService.updateTodo(todo, id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable (value = "id") long id) {
		todoService.deleteTodoById(id);
		return new ResponseEntity<String>("Todo deleted successfully!.", HttpStatus.OK);
	}
}
