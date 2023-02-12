package Todo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Todo.model.User;

import Todo.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value ="/registration", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistrationController {
	@Autowired
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@PostMapping
	public ResponseEntity<User> registerUserAccount(@RequestBody User user) {
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
}