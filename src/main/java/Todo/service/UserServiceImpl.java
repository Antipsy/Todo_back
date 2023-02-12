package Todo.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import Todo.exception.ResourceNotFoundException;
import Todo.model.Todo;
import Todo.model.User;

import Todo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	



	@Override
	public List<Todo> gettodosByUser(long id) {
		return userRepository.gettodosByUser(id);
		
	}
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		return user;
	}
	@Override
	public User save(User user) {
		User Newuser = new User();
		Newuser.setNom(user.getNom());
		Newuser.setPrenom(user.getPrenom());
		Newuser.setEmail(user.getEmail());
		Newuser.setPassword(user.getPassword()); 
		Newuser.setRole("utilisateur");
		
		return userRepository.save(Newuser);
	}
	@Override
	public User updateUser(User user,long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", id));
		existingUser.setNom(user.getNom());
		existingUser.setPrenom(user.getPrenom());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setRole(user.getRole());
		userRepository.save(existingUser);
		return existingUser;
	}
	@Override
	public User addtodo(long id,Todo todo) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", id));
		;
		existingUser.addTodo(todo);
		
		return userRepository.save(existingUser);
	}
	
}