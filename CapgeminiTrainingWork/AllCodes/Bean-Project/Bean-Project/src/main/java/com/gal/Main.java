package com.gal;

import java.util.Map;

import org.springframework.cglib.core.ClassLoaderAwareGeneratorStrategy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.gal");
		context.refresh();
		WordCounter counter = context.getBean(WordCounter.class);
		Map<String, Integer> mapOfCount = counter.getMapOfCount();
		System.out.println(mapOfCount);
		
//		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
//		context.setParent(xmlContext);
		
		
	}

}
