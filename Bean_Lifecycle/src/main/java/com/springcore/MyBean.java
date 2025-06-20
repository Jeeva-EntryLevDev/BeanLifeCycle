package com.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MyBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	@Override
	public void setBeanName(String name) {     // - Useful for logging, custom logic, or conditional behavior based on the bean name.
		System.out.println("setBeanName : Spring calls this method during bean initialization : Hey bean, this is your name in the container " + name);	
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory : BeanFactoryAware → BeanFactory injected");
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware → ApplicationContext injected");
	}

}



/* 
 	Why Use Aware Interfaces?
	They allow Spring-managed beans to gain awareness of the container and environment they live in—but without hard-coding or tight coupling. It’s like giving beans some superpowers to see beyond themselves


 * This method's definitions are already in Interfaces --> BeanNameAware, BeanFactoryAware, ApplicationContextAware
 	🅰️ setBeanName(String name) from BeanNameAware
	- Spring calls this method during bean initialization.
	- It passes the ID (name) the bean was registered with.
	- Useful for logging, custom logic, or conditional behavior based on the bean name.
	🧠 “Hey bean, this is your name in the container.

	🅱️ setApplicationContext(ApplicationContext ctx) from ApplicationContextAware
	- Spring injects the ApplicationContext itself.
	- Now your bean can:
	- Access other beans via ctx.getBean(...)
	- Get environment details
	- Publish events
	🧠 “Here’s the full context if you need to talk to other beans or read config.

	🆎 setBeanFactory(BeanFactory beanFactory) from BeanFactoryAware
	- Gives access to the lower-level BeanFactory (the basic interface behind ApplicationContext).
	- You can:
	- Query bean metadata
	- Check for singleton/prototype status
	- Lazily obtain other beans
	🧠 “If you're into the plumbing behind Spring, here's the toolkit.

*/
