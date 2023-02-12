package Todo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Todo.exception.ResourceNotFoundException;

import Todo.model.Todo;
import Todo.model.User;
import Todo.repository.TodoRepository;
import Todo.repository.UserRepository;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Todo> getAllTodosByid(long userid) {
		return todoRepository.findTodoByuser(userid);
		
	}
	@Override
	public Todo saveTodo(Todo todo) {
		Todo Newtodo = new Todo();
		Newtodo.setTitle(todo.getTitle());
		Newtodo.setDescription(todo.getDescription());
		Newtodo.setStatue(todo.getStatue());
		long usrId = todo.getUser();
		Newtodo.setUser(usrId);
		User user = userRepository.getUserByid(usrId);
		todoRepository.save(Newtodo);
		user.addTodo(Newtodo);
		userRepository.save(user);
		
		return todo;
	}

	@Override
	public Todo getTodoById(long id) {
		
		return  todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "todo_id", id));
	}
	@Override
	public Todo updateTodo(Todo todo,long id) {
		Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "todo_id", id));
		existingTodo.setTitle(todo.getTitle());
		existingTodo.setDescription(todo.getDescription());
		existingTodo.setStatue(todo.getStatue());
		existingTodo.setUser(todo.getUser());
		todoRepository.save(existingTodo);
		return existingTodo;
	}
	@Override
	public void deleteTodoById(long id) {
		 Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "event_id", id));
		 long usrId = existingTodo.getUser();
		 User user = userRepository.getUserByid(usrId);
		 user.removeTodo(existingTodo);
		 userRepository.save(user);
		 todoRepository.deleteById(id);
		
	}
}
