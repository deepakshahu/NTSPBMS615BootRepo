//WishMessgaeGenerator.java(Target class)
package com.nit.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("wmg")  //Spring bean configuration having "wmg" as bean id
@Component
public class WishMessageGenerator {
	//HAS-A property
	@Autowired  //Annotation marking the HAS-A property for Dependency Injection/Management
	private LocalDateTime ldt;  //By default holds null...after injection/wiring this null will be replaced 
	//with Dependent LocalDateTime class object

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator :: 0-param constructor");
	}

	//Business method
	public String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		//Get current hour
		int hour = ldt.getHour();  //24 hours format
		System.out.println(ldt);
		if(hour<12)
			return "Good Morning :: "+user;
		else if(hour<16)
			return "Good Afternoon :: "+user;
		else if(hour<20)
			return "Good Evening :: "+user;
		else
			return "Good Night :: "+user;
	}//method
}//class