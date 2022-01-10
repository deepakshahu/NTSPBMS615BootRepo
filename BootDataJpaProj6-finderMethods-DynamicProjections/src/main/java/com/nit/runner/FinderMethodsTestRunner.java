package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.Movie;
import com.nit.repository.IMovieRepo;
import com.nit.view.ResultView1;
import com.nit.view.ResultView2;
import com.nit.view.ResultView3;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;  //InMemory proxy class obj of our repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {

		/*Iterable<ResultView1> it = repo.findByMnameIn(List.of("RRR","Don"), ResultView1.class);
		it.forEach(v1->System.out.println(v1.getMid()+" "+v1.getMname()));
		System.out.println("--------------------------------");
		repo.findByMnameIn(List.of("RRR","Don"), ResultView2.class).forEach(v2->System.out.println(v2.getMid()+" "+v2.getMname()+" "+v2.getRating()));
		System.out.println("----------------------------------");
		repo.findByMnameIn(List.of("RRR","Don"), ResultView3.class).forEach(v3->System.out.println(v3.getMid()+" "+v3.getMname()+" "+v3.getYear()));
		System.out.println("-----------------------------------");*/
		Movie movie = new Movie();
		movie.setMname("Spider-Man");
		movie.setRating(4.8f);
		movie.setYear("2022");
		System.out.println(repo.save(movie).getMid()+" --- Object is saved");
	}
}