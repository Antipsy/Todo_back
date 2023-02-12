package Todo.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Todo.model.Todo;
import Todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u from User u Where u.email = :email")
	public User getUserByUsername(@Param("email") String email);
	@Query("SELECT u from User u Where u.email = :email AND u.password = :password")
	public User getUserByUsernamePass(@Param("email") String email,@Param("password") String password);
	@Query("SELECT u from User u Where u.id = :id")
	public User getUserByid(@Param("id") long id);
	
	@Query("SELECT u.todos from User u Where u.id = :id")
	public List<Todo> gettodosByUser(@Param("id") long id);
	
}