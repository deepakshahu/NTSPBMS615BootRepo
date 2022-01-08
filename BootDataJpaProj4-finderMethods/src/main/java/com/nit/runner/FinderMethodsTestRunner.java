package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.repository.IMovieRepo;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;  //InMemory proxy class obj of our repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		/*//========finder methods========
		repo.findByMnameEquals("Don").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findByMnameIs("Baghi").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findBymname("Baghi").forEach(System.out::println);
		
		System.out.println("--------------------------");
		repo.findByMnameStartingWith("Do").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findByMnameEndingWith("n").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findByMnameContaining("a").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findByMnameEqualsIgnoreCase("doN").forEach(System.out::println);
		System.out.println("--------------------------");
		repo.findByMnameContainingIgnoreCase("hI").forEach(System.out::println);
		System.out.println("--------------------------");
		//repo.findByMnameLike("R%").forEach(System.out::println);
		//repo.findByMnameLike("___").forEach(System.out::println);
		//repo.findByMnameLike("%R").forEach(System.out::println);
		repo.findByMnameLike("%R%").forEach(System.out::println);
		*/
		System.out.println("=======finder methods with multiple properties based conditions===============");
		repo.findByMidGreaterThanAndRatingLessThan(30, 4.8f).forEach(System.out::println);
		System.out.println("-------------------------------");
		repo.findByMnameStartingWithOrRatingBetween("R", 3.5f, 5.1f).forEach(System.out::println);
		System.out.println("--------------------------------");
		repo.findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List.of("2021","2022"), "R", 3.0f, 5.0f).forEach(System.out::println);
		System.out.println("---------------------------------");
		repo.findByMnameNotLikeAndYearInOrderByMnameAsc("R%", List.of("2020","2021")).forEach(System.out::println);
	}
}