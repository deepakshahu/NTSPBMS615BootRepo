package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.repository.IMovieRepo;
import com.nit.view.ResultView;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;  //InMemory proxy class obj of our repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Repository impl class name :: "+repo.getClass());
		Iterable<ResultView> it = repo.findByMidGreaterThanEqualAndMidLessThanEqual(30, 45);
		it.forEach(view->{
			System.out.println("Dynamic model class name :: "+view.getClass());
			System.out.println(view.getMid()+" "+view.getMname());
		});
		
	}
}