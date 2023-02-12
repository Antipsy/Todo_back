package Todo.service;



import java.util.List;

import Todo.model.Todo;
import Todo.model.User;

public interface UserService{
	User getUserById(long id);
	User updateUser(User user, long id);
	User save(User user);
	User addtodo(long id,Todo todo);
	List<Todo> gettodosByUser(long id);
}