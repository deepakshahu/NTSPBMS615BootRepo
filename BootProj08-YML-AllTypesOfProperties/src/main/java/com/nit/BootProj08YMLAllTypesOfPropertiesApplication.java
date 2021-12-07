package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.beans.PersonInfo;

@SpringBootApplication
public class BootProj08YMLAllTypesOfPropertiesApplication {

	public static void main(String[] args) {

		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj08YMLAllTypesOfPropertiesApplication.class, args);

		//Get Spring bean class object
		PersonInfo person = ctx.getBean("pInfo",PersonInfo.class);

		//Invoke the method
		System.out.println("Person Info object details: "+person);

		//Close container
		((ConfigurableApplicationContext) ctx).close();
	}
}