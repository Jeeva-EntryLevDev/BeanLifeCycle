package com.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class FullBeanWithAllInterfacesMethods implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean{

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
	
	@Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof MyBean) {
            System.out.println("🔧 BeanPostProcessor BEFORE init → " + beanName);
        }
        return bean;
    }

	@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof MyBean) {
            System.out.println("🔧 BeanPostProcessor AFTER init → " + beanName);
        }
        return bean;
    }
	
	
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
