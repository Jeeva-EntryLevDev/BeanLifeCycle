package com.example.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Java-based annotation scanning.

@Component
class HelloWorld {
	public void sayHello() {
		System.out.println("Hello, Spring IoC!");
	}
}

@Configuration
@ComponentScan("com.example.springcore")  // Scans this package for @Component classes
public class AppConfig {
	public static void main(String[] args) 
	{
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
		    HelloWorld helloWorld = context.getBean(HelloWorld.class);
		    helloWorld.sayHello();
		} // Context is automatically closed when exiting the try block
	}
	
	
}


