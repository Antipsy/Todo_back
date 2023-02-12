package Todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import Todo.model.User;
import Todo.repository.UserRepository;
import Todo.service.UserService;

@RestController
public class MainController {
	@Autowired
    UserRepository userRepository;
	@Autowired
    UserService userService;
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	@PostMapping(value ="/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	public ResponseEntity<User> login(@RequestBody User user) {
		User userEmail =userRepository.getUserByUsernamePass(user.getEmail(),user.getPassword());
		
		return new ResponseEntity<User>(userEmail, HttpStatus.OK);

		
	}
	@PostMapping(value ="/logout", produces = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	public ResponseEntity<String> logout() {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	@GetMapping("/")
	public String index() {
		return "index";
	}
}