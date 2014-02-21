package com.placeMe.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
	
	public static SpringContext INSTANCE = new SpringContext();
	private ApplicationContext context;
	
	private SpringContext(){}
	
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}
	
	/**
	 * Il metodo restituisce un bean dal context di spring.
	 * 
	 * @param bean
	 * @param clazz
	 * @return
	 */
	public <T> T getBean(String bean, Class<T> clazz){
		Object o = context.getBean(bean, clazz);
		return clazz.cast(o);
	}
}
