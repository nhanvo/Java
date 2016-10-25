package com.nhanvo.SpringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhanvo.SpringAnnotation.bean.GreetingService;
import com.nhanvo.SpringAnnotation.bean.MyComponent;
import com.nhanvo.SpringAnnotation.bean.MyRepository;
import com.nhanvo.SpringAnnotation.config.AppConfiguration;
import com.nhanvo.SpringAnnotation.lang.Language;

/**
 * Hello world!
 *
 */
public class MainProgram 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Language language = (Language) context.getBean("language");
        
        System.out.println("Bean language: " + language);
        System.out.println("Call language sayBye: " + language.getBye());
        
        /**
         * [greetingService] bean is auto create by Spring
         */
        GreetingService service = (GreetingService) context.getBean("greetingService");
        service.sayGreeting();
        
        /**
         * [myComponent] bean is auto create by Spring
         */
        MyComponent component = (MyComponent) context.getBean("myComponent");        
        component.showAppInfo();
        
        /**
         * [myRepository] bean is auto create by Spring
         */
        MyRepository repository = (MyRepository) context.getBean("myRepository");
        System.out.println(repository.getAppName());
        System.out.println(repository.getSystemDateTime());
        
        /**
         * Show all bean name in application
         */
        String beans[] = context.getBeanDefinitionNames();
        for (String b : beans) {
        	System.out.println(b);
        }
        
    }
}
