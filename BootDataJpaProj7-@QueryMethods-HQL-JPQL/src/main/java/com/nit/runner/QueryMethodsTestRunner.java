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
		
		System.out.println("===========Query methods execution(Selecting all column values)==========");
		/*List<Movie> list = repo.searchMoviesByIdRange(30, 50);
		list.forEach(System.out::println);*/
		System.out.println("------------------------------------------");
		repo.searchMoviesByMnames("RRR", "Don", "Baghi").forEach(System.out::println);
		System.out.println("------------------------------------------");
		repo.searchMoviesByMnames1("RRR", "Don", "Baghi").forEach(System.out::println);
		
		System.out.println("============Scalar Queries(Selecting specific multiple column values)============");
		repo.fetchMovieDetailsByRatingsAndYear(4.0f, "2020", "2021", "2022").forEach(row->{
			for(Object val:row)
				System.out.print(val+" ");
			
			System.out.println();
		});
		
		System.out.println("============Scalar Queries(Selecting specific single column values)============");
		repo.fetchMoviesByYearRange("2020", "2022").forEach(System.out::println);
	}
}