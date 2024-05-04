package com.takima.backskeleton;

import com.takima.backskeleton.models.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackSkeletonApplication.class, args);
		Users user = new Users();
		String plainTextPassword = "mySecretPassword";

		// Set the password using BCrypt hashing
		user.setPassword(plainTextPassword);
		String hashedPassword = user.getPassword_mdp();

		// Verify the password
		boolean passwordMatch = user.checkPassword(plainTextPassword);

		if (passwordMatch) {
			System.out.println("Password matches!");
		} else {
			System.out.println("Password mismatch!");
		}
	}
}



