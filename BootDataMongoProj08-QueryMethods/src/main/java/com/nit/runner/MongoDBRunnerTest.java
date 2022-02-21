package com.nit.runner;

import java.util.Arrays;

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
		
		//touristService.fetchAllTouristsByNativePlace("UP").forEach(System.out::println);
		
		//touristService.fetchAllTouristsByNativePlaceAndAge("UP",21.5f).forEach(System.out::println);
		
		//touristService.fetchAllTouristsByAgeRange(22.5f, 46.7f).forEach(System.out::println);
		
		//touristService.fetchAllTouristsByNativePlaces("UP", "Bihar").forEach(System.out::println);
		
		//touristService.fetchTouristDataByNativePlace("UP").forEach(row->{
			/*for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();*/
			//System.out.println(Arrays.toString(row));
		//});
		
		touristService.fetchTouristDataByNativePlaces("UP", "Bihar", "Pune").forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
	}// run
}// class