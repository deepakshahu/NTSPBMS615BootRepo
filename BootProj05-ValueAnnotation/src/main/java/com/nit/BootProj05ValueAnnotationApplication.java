package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nit.beans.Hospital;

@SpringBootApplication
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {

		//Get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);

		//Get Spring bean class object
		Hospital hospital = ctx.getBean("hsptl",Hospital.class);

		//invoke the method
		System.out.println("Spring bean class object data: "+hospital);
		System.out.println("=====================================");
		//System.out.println("System properties are: "+System.getProperties());
		Environment env = ctx.getEnvironment();
		System.out.println("Environement object data: "+env.toString());
		System.out.println("os.name value: "+env.getProperty("os.name"));  //system properties
		System.out.println("hsptl.name key's value: "+env.getProperty("hsptl.name"));  //properties file
		System.out.println("Path : "+env.getProperty("Path"));  //environment variable

		//Close container
		((ConfigurableApplicationContext) ctx).close();
	}
}