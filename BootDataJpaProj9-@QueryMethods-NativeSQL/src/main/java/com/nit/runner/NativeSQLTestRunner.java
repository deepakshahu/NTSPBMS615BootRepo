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
		int result = repo.registerMovie("Housefull", 4.6f, "2015");
		System.out.println(result==0?"Movie not registered":"Movie registered");
	}//run(-)
}//class