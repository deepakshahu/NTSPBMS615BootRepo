package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.service.ITouristMgmtService;

@Component
public class MongoDBRunnerTest implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService touristService;

	@Override
	public void run(String... args) throws Exception {
		
		//touristService.fetchTouristByNativePlaceWithRegex("^U").forEach(System.out::println);  //starts with U
		//touristService.fetchTouristByNativePlaceWithRegex("r$").forEach(System.out::println);  //ends with r
		//touristService.fetchTouristByNativePlaceWithRegex("a").forEach(System.out::println);  //contains a
		
		//System.out.println("Tourist count :: "+touristService.fetchTouristsCountByAgeRange(24.5f, 33.7f));
		
		//touristService.fetchTouristsSortedByName().forEach(System.out::println);
		
		//System.out.println("Deleted documents count is :: "+touristService.removeTouristsWithNoContactNumber());
		
		System.out.println("Does the tourist exist without vaccination :: "+touristService.isThereTouristsWithOutVaccination());
		
	}// run
}// class