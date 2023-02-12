package Todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;


import Todo.model.User;

import Todo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setNom("El Bakbachi");
		user.setPrenom("Wassim");
		user.setEmail("wassim@gmail.com");
		user.setPassword("wassim123"); 
		user.setRole("utilisateur");

		userRepository.save(user);

		

		
	}
}
