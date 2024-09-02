package com.example.SB_1.SB_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb1Application implements CommandLineRunner {

	@Autowired
//	Autowire annotation notify spring framework that the Apple object "obj" should be injected wherever required.
	Apple obj1;

	@Autowired
	Apple obj2;

	@Autowired
	DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(Sb1Application.class, args);
//		spring interact with large no. of users, so it will create lot of data if we create new object for every user.
//		also there will be no more handling lifecycle of those objects
//		Apple obj2 = new Apple();
//		obj2.eatApple();
	}

	@Override
	public void run(String... args) throws Exception {
//		Singleton
//		eatApple function called twice with 2 different objects but "callThisBeforeAppleUsed" called only once
		obj1.eatApple();
		obj2.eatApple();

		System.out.println(dbService.getData());
	}
}
