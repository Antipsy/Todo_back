package Todo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Todo.model.Todo;
import Todo.model.User;

import Todo.service.UserService;

@RestController
@RequestMapping(value="/Users", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable (value = "id") long id, @RequestBody User user) {
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
	}
	@PutMapping("{id}/todo")
	public ResponseEntity<User> addTodo(@PathVariable (value = "id") long id,@RequestBody Todo todo) {
		
		return new ResponseEntity<User>(userService.addtodo(id,todo),HttpStatus.OK);
	}
	
}
