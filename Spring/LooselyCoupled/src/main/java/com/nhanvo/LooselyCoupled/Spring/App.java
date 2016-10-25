package com.nhanvo.LooselyCoupled.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		
		/**
		 * Not need change code at here. If you want change output to JSON then change at SpringBeans.xml file.
		 */
		OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
		output.generateOutput();
		
		/**
		 * Check bean name in application.
		 */
		for(String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}
}
