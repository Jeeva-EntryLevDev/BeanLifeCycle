package com.springcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class MyBean1 implements InitializingBean, DisposableBean {
	
	@PostConstruct
	public void PostConstructInit() {
	    System.out.println("@PostConstruct : Bean is ready to go!");
	}
	
	@PreDestroy
	public void PreDestroy() {
	    System.out.println("@PreDestroy : Bean is being destroyed.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("✅ afterPropertiesSet() → Custom init logic");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("🧹 destroy() → Cleanup before bean is destroyed");
	}
	
	public void called() {
		System.out.println(" called : The method called from AppConfig");
	}
	
}
