package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456", "988888888" );
		
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456", "985488888");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
	
}
