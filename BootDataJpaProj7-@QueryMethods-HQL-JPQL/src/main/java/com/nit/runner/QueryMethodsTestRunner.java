package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.Movie;
import com.nit.repository.IMovieRepo;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;  //InMemory proxy class obj of our repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("===========Query methods execution==========");
		List<Movie> list = repo.searchMoviesByIdRange(30, 50);
		list.forEach(System.out::println);
	}
}