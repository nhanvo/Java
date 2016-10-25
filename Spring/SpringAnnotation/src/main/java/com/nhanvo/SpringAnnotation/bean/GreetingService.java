package com.nhanvo.SpringAnnotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhanvo.SpringAnnotation.lang.Language;

@Service
public class GreetingService {
	@Autowired
	private Language language;
	
	public void sayGreeting() {
		String greeting = language.getGreeting();
		System.out.println("Greeting: " + greeting);
	}
}
