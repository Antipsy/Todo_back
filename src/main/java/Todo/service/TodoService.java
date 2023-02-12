package Todo.service;

import java.util.List;
import Todo.model.Todo;


public interface TodoService {
	Todo getTodoById(long id);
	List<Todo> getAllTodosByid(long userid);
	Todo saveTodo(Todo todo);
	Todo updateTodo(Todo todo, long id);
	void deleteTodoById(long id);

	
	
}
