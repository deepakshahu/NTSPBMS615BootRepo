package com.nit;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nit.dao.EmployeeDAO;

@SpringBootApplication
public class BootProj02AutoConfigurationApplication {
	
	@Bean
	public DataSource createDs() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("system");
		cpds.setPassword("manager");
		return cpds;
	}

	public static void main(String[] args) throws Exception{
		
		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj02AutoConfigurationApplication.class, args);
		
		//Get DAO class object reference
		EmployeeDAO dao = ctx.getBean("empDAO",EmployeeDAO.class);
		
		//Invoke the method
		System.out.println("Emps count: "+dao.getEmpsCount());
		
		//Close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class