package Todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	@Query("SELECT t from Todo t Where t.id = :id")
	public Todo getTodoByid(@Param("id") long id);
	@Query("SELECT t FROM Todo t WHERE t.title = :title")
	public Todo findTodoByTitle(@Param("title")String title);
	@Query("SELECT t FROM Todo t WHERE t.user = :user")
	public List<Todo> findTodoByuser(@Param("user")long user);
	
	
}
