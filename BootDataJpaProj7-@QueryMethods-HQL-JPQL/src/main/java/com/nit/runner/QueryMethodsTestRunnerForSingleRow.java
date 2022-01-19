package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.Movie;
import com.nit.repository.IMovieRepo;

@Component
public class QueryMethodsTestRunnerForSingleRow implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;  //InMemory proxy class obj of our repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {

		System.out.println("===========Query methods execution(Single Row)==========");
		Movie movie = repo.fetchMovieDataByMname("Anthim");
		if(movie!=null)
			System.out.println("RRR movie details are : "+movie);
		else
			System.out.println("No movie found");
		
		System.out.println("===========Single Row Scalar Query giving specific multiple column values==========");
		Object data = repo.fetchMoviePartialDataByMname("Anthim");
		Object result[] = (Object[]) data;
		for(Object val:result) {
			System.out.print(val+" ");
		}
		System.out.println();
		
		System.out.println("===========Single Row Scalar Query giving specific single column value==========");
		String year = repo.fetchMovieSingleDataByMname("Anthim");
		System.out.println("Anthim movie release year :: "+year);
		
		System.out.println("===========Executing single aggregate function============");
		System.out.println("Highest rating for movie :: "+repo.fetchMaxRatingMovie());
		
		System.out.println("===========Executing multiple aggregate function============");
		Object results1[] = (Object[])repo.fetchAggregateDataOnMovies();
		System.out.println("Max Rating :: "+results1[0]);
		System.out.println("Min Rating :: "+results1[1]);
		System.out.println("Avg Rating :: "+results1[2]);
		System.out.println("Count of Movies :: "+results1[3]);
		System.out.println("Average of years :: "+results1[4]);
		System.out.println("Sum of years :: "+results1[5]);
		
		System.out.println("============Executing sub query=====================");
		repo.fetchMaxRatingMovies().forEach(System.out::println);
		
	}//run
}//class