package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.beans.CustomerInfo;
import com.nit.beans.EmployeeDetails;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {

		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj06ConfigurationPropertiesAnnotationApplication.class, args);

		//Get Spring bean class object of CustomerInfo class
		CustomerInfo info = ctx.getBean("custInfo",CustomerInfo.class);

		//Invoke the method of CustomerInfo class
		System.out.println("Customer info object data: "+info);
		
		System.out.println("======================================================");

		//Get Spring bean class object of EmployeeDetails class
		EmployeeDetails details = ctx.getBean("employeeDetails",EmployeeDetails.class);

		//Invoke the method of EmployeeDetails class
		System.out.println("Employee details object data: "+details);

		//Close container
		((ConfigurableApplicationContext) ctx).close();
	}
}