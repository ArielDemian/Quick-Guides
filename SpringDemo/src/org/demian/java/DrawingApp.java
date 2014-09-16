package org.demian.java;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		// BeanFactory factory = new XmlBeanFactory(new
		// FileSystemResource("spring.xml"));
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		context.close();
	}
}