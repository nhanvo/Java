package com.nhanvo.SpringAnnotation.langimpl;

import com.nhanvo.SpringAnnotation.lang.Language;

public class Vietnamese implements Language{

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Xin chao";
	}

	@Override
	public String getBye() {
		// TODO Auto-generated method stub
		return "Tam biet";
	}

}
