package Todo.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.JoinColumn;

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "auth_user_id")
	private long id;
	
	@Column(name = "Nom")
	private String nom;
	
	@Column(name = "Prenom")
	private String prenom;
	private String email;
	private String password;
	private String Role;
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL,orphanRemoval =true)
	@JoinTable(name="user_todos", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<Todo> todos =new HashSet<>();
	
	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void addTodo(Todo todo) {
		this.todos.add(todo);
		
	}
	public void removeTodo(Todo todo) {
		this.todos.remove(todo);
		
	}
	@Override
	public String toString() {
		return this.nom +" "+this.prenom;
	}
	
	
	

}