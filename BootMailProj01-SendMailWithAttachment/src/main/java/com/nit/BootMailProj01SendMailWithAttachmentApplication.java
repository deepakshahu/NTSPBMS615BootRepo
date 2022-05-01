package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.service.IShopping;

@SpringBootApplication
public class BootMailProj01SendMailWithAttachmentApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootMailProj01SendMailWithAttachmentApplication.class, args);
		
		//get Service class object
		IShopping service = ctx.getBean("shopping", IShopping.class);
		
		//Invoke the method
		try {
			String result = service.shopping(new String[] {"shirt","trouser","belt"}, 
																			  new float[] {1600.0f, 4300.58f, 1200.5f}, 
																			  new String[] {"shahu.deepak04@gmail.com","anonymous4u96@gmail.com"});
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class