package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.repository.IMovieRepo;

@Component
public class NonSelectOperationsRunner implements CommandLineRunner {
	
	@Autowired
	private IMovieRepo repo;

	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("Updating "+repo.modifyRatingByMovieName(4.5f, "RRR")+" movies");
		
		System.out.println(repo.deleteMovieByYearRange("1980", "2015")+" Movies are deleted");
	}
}