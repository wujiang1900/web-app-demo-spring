package com.myapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.myapp.domain.User;
import com.myapp.repository.UserRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of Users
		repository.save(new User("Alice", "Smith"));
		repository.save(new User("Bob", "Smith"));

		// fetch all Users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User User : repository.findAll()) {
			System.out.println(User);
		}
		System.out.println();

		// fetch an individual User
		System.out.println("User found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByUserName("Alice"));


	}

}