package com.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springcore")
public class AppConfig {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
				// Even you don't create objects for the classes MyBean and MyBean1 it would be implemented
			
		}

	}

}
