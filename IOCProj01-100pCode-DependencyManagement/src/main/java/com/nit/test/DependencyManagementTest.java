package com.nit.test;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.beans.WishMessageGenerator;
import com.nit.config.AppConfig;

public class DependencyManagementTest {

	public static void main(String[] args) {

		//Create IOC Container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		//Get Target class object
		//WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);  //To avoid typeCasting, use java generics
		WishMessageGenerator generator = ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
		
		//Invoke the business method
		String result = generator.generateWishMessage("Deepak");
		System.out.println(result);
		System.out.println("===================");
		LocalDateTime ldt = ctx.getBean("createLDT",LocalDateTime.class);
		System.out.println(ldt);

		//Close stream
		ctx.close();
	}//main
}//class