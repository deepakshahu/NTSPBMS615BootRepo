package com.nit;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.PayrollSystemController;
import com.nit.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectLayeredAppApplication {

	public static void main(String[] args) {

		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniProjectLayeredAppApplication.class, args);

		//Get Controller class object
		PayrollSystemController controller = ctx.getBean("controller",PayrollSystemController.class);

		//Invoke Business Method
		try(Scanner sc = new Scanner(System.in)) {
			//Read inputs from end user
			System.out.print("Enter designation 1: ");
			String desg1 = sc.next().toUpperCase();
			System.out.print("Enter designation 2: ");
			String desg2 = sc.next().toUpperCase();
			System.out.print("Enter designation 3: ");
			String desg3 = sc.next().toUpperCase();

			List<Employee> listEmps = controller.showEmpsByDesgs(desg1, desg2, desg3);

			/*//For Loop for iterating ArrayList 
			for (int i = 0; i < listEmps.size(); i++) { 		      
		          System.out.println(listEmps.get(i)); 		
		      }*/

			/*//Advanced For Loop	
		      for (Employee e : listEmps) { 		      
		           System.out.println(e); 		
		      }*/

			/*//While Loop for iterating ArrayList 		
			System.out.println("While Loop"); 		
			int count = 0; 		
			while (listEmps.size() > count) {
				System.out.println(listEmps.get(count));
				count++;
			}*/

			/*//Looping Array List using Iterator
		      Iterator<Employee> iter = listEmps.iterator();
		      while (iter.hasNext()) {
		         System.out.println(iter.next());
		      }*/
			
			//ArrayList forEach() method-Java8 syntax 1
			//listEmps.forEach(emp  ->{System.out.println(emp);});
			
			//ArrayList forEach() method-Java8 syntax 2
			//listEmps.forEach(emp  ->System.out.println(emp));
			
			//Method Reference forEach() method -Java8
			listEmps.forEach(System.out::println);
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Internal DB problem::"+se.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal unknown problem::"+e.getMessage());
		}

		//Close IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}
}