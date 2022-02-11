package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.Tourist;
import com.nit.service.ITouristMgmtService;

@Component
public class MongoDBFinderMethodsRunnerTest implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService touristService;

	@Override
	public void run(String... args) throws Exception {
		
		//================calling finder methods====================
		//touristService.fetchTouristsByNativePlaceAscOrder("UP").forEach(System.out::println);;
		System.out.println("=========================");
		Tourist tourist = touristService.fetchTouristsByContactNo(7977779643L);
		if(tourist==null)
			System.out.println("Tourist not found");
		else
			System.out.println("Tourist details :: "+tourist);
		
	}// run
}// class