package com.nit.test;

import java.util.ArrayList;
import java.util.Date;

import com.nit.comp.Employee;
import com.nit.comp.Person;
import com.nit.comp.Student;

public class App {
	
	public <T> T showDetails(Class<T> clazz) throws Exception{
		return clazz.getDeclaredConstructor(new Class[] {}).newInstance();
	}
	
	public<T extends Person> T showDetails1(Class<T> clazz) throws Exception{
		return clazz.getDeclaredConstructor(new Class[] {}).newInstance();
	}

	public static void main( String[] args ) throws Exception{
		App app = new App();
		Student st = app.showDetails(Student.class);
		System.out.println(st);
		System.out.println("-------------------------------");
		Employee emp = app.showDetails(Employee.class);
		System.out.println(emp);
		System.out.println("--------------------------------");
		ArrayList list = app.showDetails(ArrayList.class);
		System.out.println(list);
		System.out.println("---------------------------------");
		Date date = app.showDetails(Date.class);
		System.out.println(date);
		System.out.println("=========================");
		
		App app1 = new App();
		Student st1 = app1.showDetails1(Student.class);
		System.out.println(st1);
		System.out.println("-------------------------------");
		Employee emp1 = app1.showDetails1(Employee.class);
		System.out.println(emp1);
		System.out.println("--------------------------------");
		/*ArrayList list1 = app1.showDetails1(ArrayList.class);
		System.out.println(list1);
		System.out.println("---------------------------------");
		Date date1 = app.showDetails1(Date.class);
		System.out.println(date);*/
	}
}