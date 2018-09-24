package com.de.hamza.hibernateSpringFlywayLog4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.de.hamza.hibernateSpringFlywayLog4j.entity.User;
import com.de.hamza.hibernateSpringFlywayLog4j.repository.UserRepository;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages="com.de.hamza.hibernateSpringFlywayLog4j")
public class App
{
	public static ApplicationContext context;
	
	@Autowired(required=true)
	private UserRepository userRepository;
	
	void saveUser(User user){
		userRepository.add(user);
	};
	
    public static void main( String[] args )
    {
    	// get the ApplicationContext impl. in this case "AnnotationConfigApplicationContext"
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	context.register(AppConfig.class);
    	App a = context.getBean(App.class);
    	User u = new User("Salah","Salih");
    	a.saveUser(u);
    }
}
