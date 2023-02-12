package Todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private long id;
	
	@Column(name = "Title")
	private String title;
	
	private String description;
	private String statue;
	private long user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}
	
	public Todo() {
		super();
	}
	
	public Todo(String title, String description, String statue, long user) {
		super();
		this.title = title;
		this.description = description;
		this.statue = statue;
		this.user = user;
	}

	@Override
	public String toString() {
		return this.title;
	}
	
	
}
