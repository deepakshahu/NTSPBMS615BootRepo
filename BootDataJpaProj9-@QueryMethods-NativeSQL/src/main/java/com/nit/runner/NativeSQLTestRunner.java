package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.repository.IMovieRepo;

@Component
public class NativeSQLTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepo repo;

	@Override
	public void run(String... args) throws Exception {
		/*int result = repo.registerMovie("Housefull", 4.6f, "2015");
		System.out.println(result==0?"Movie not registered":"Movie registered");*/
		System.out.println("----------------------------------------------");
		
		System.out.println("Date and Time is :: "+repo.fetchSysDate());
		System.out.println("----------------------------------------------");
		
		int count = repo.createTempTable();
		System.out.println(count<0?"Table is not created":"Table is created");
		
	}//run(-)
}//class