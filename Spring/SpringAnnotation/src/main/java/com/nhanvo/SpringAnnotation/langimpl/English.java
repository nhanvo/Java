package com.nhanvo.SpringAnnotation.langimpl;

import com.nhanvo.SpringAnnotation.lang.Language;

public class English implements Language{

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hello";
	}

	@Override
	public String getBye() {
		// TODO Auto-generated method stub
		return "Bye bye";
	}
	
}
