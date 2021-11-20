package com.nit;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nit.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	@Bean(name="cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();  //return Calendar class object(sub class of calendar)
	}

	public static void main(String[] args) {
		
		//Bootstrap(start) spring boot app and get IOC Container ref
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		
		//Get Target class object
		WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);
		
		//Invoke the business Method
		String result = generator.generateWishMessage("Deepak");
		System.out.println("Wish Message is :: "+result);
		
		//Close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class