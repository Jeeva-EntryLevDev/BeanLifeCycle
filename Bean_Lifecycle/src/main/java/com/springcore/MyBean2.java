package com.springcore;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class MyBean2 implements BeanPostProcessor{
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

}


/*
  postProcessBeforeInitialization(Object bean, String beanName)
- This method is called before any custom init methods like @PostConstruct or afterPropertiesSet().
- You can use it to manipulate the bean, validate state, wrap with proxies, or simply log/monitor.

- If you return null, the bean won’t be registered—so be cautious!
⏳ Think of it as: “The bean is just born, but not fully awake yet—want to tweak anything before Spring finishes setting it up?


⚙️ postProcessAfterInitialization(Object bean, String beanName)
- Called after the init phase is complete, including any @PostConstruct, afterPropertiesSet(), or custom init-methods.
- A common use case is wrapping the bean in a proxy (for AOP, security, logging, etc.)

*/
