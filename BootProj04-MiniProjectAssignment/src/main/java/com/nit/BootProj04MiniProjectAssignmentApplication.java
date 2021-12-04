package com.nit;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.CoronaController;
import com.nit.model.Corona;

@SpringBootApplication
public class BootProj04MiniProjectAssignmentApplication {

	public static void main(String[] args) {

		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj04MiniProjectAssignmentApplication.class, args);

		//Get Controller class object
		CoronaController controller = ctx.getBean("controller",CoronaController.class);

		//Invoke Business Method
		try(Scanner sc = new Scanner(System.in)) {
			//Read inputs from end user
			System.out.print("Enter city 1: ");
			String city1 = sc.next().toUpperCase();
			System.out.print("Enter city 2: ");
			String city2 = sc.next().toUpperCase();
			System.out.print("Enter city 3: ");
			String city3 = sc.next().toUpperCase();

			List<Corona> listPatients = controller.showPatientsByCities(city1, city2, city3);

			/*//For Loop for iterating ArrayList 
			for (int i = 0; i < listPatients.size(); i++) { 		      
		          System.out.println(listPatients.get(i)); 		
		      }*/

			/*//Advanced For Loop	
		      for (Corona c : listPatients) { 		      
		           System.out.println(c); 		
		      }*/

			/*//While Loop for iterating ArrayList 		
			System.out.println("While Loop"); 		
			int count = 0; 		
			while (listPatients.size() > count) {
				System.out.println(listPatients.get(count));
				count++;
			}*/

			/*//Looping Array List using Iterator
		      Iterator<Corona> iter = listPatients.iterator();
		      while (iter.hasNext()) {
		         System.out.println(iter.next());
		      }*/
			
			//ArrayList forEach() method-Java8 syntax 1
			//listPatients.forEach(c  ->{System.out.println(c);});
			
			//ArrayList forEach() method-Java8 syntax 2
			//listPatients.forEach(c  ->System.out.println(c));
			
			//Method Reference forEach() method -Java8
			listPatients.forEach(System.out::println);
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