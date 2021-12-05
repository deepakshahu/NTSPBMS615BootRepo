package com.nit.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("employeeDetails")
@ConfigurationProperties(prefix="emp.details")
@Data
public class EmployeeDetails {
	//Spring bean properties
	@Value("${emp.info.name}")
	private String name;
	private int age;
	
	EmployeeDetails(){
		System.out.println("EmployeeDetails :: 0-param costructor :: "+name);
	}
	
	public void setName(String name) {
		System.out.println("Before setter injection, field level injection takes place :: "+this.name);
		this.name=name;
		System.out.println("EmployeeDetails.setName() :: " + name);
	}
}