package com.nhanvo.SpringAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nhanvo.SpringAnnotation.lang.Language;
import com.nhanvo.SpringAnnotation.langimpl.Vietnamese;

@Configuration
@ComponentScan({"com.nhanvo.SpringAnnotation.bean"})
public class AppConfiguration {
	@Bean(name = "language")
	public Language getLanguage() {
		return new Vietnamese();
	}
}
