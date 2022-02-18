package com.nit.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.Medal;
import com.nit.document.Player;
import com.nit.document.Sport;
import com.nit.service.ISportsMgmtService;

@Component
public class OneToManyAssociationRunnersTest implements CommandLineRunner {
	@Autowired
	private ISportsMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {
			//Child class1 objects
			Sport sport1 = new Sport(new Random().nextInt(1000), "Badminton", new String[] {"Racket","Shoes","Shuttlecock","Towel","First aid"});
			Sport sport2 = new Sport(new Random().nextInt(1000), "Tennis", new String[] {"Racquets","Balls","Ball Hoppers","Equipment","Footwear"});

			//Child class2 objects
			Medal medal1 = new Medal(UUID.randomUUID().toString().replace("-","").substring(0,10), "Gold", "Tokyo-2020", "Tokyo");
			Medal medal2 = new Medal(UUID.randomUUID().toString().replace("-","").substring(0,10), "Silver", "Commonwealth Games", "Tokyo");

			//Parent class objects
			Player player = new Player(new Random().nextInt(1000), "PV SIndhu", "Hyderabad", Set.of(sport1, sport2), Map.of("medal1",medal1, "medal2", medal2));

			//Invoke the method
			System.out.println(service.registerPlayerWithSportsAndMedals(player));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("==============================================");
		
		service.fetchAllPlayersInfo().forEach(per->{
			System.out.println("Parent :: "+per);
			//Access child1 objects
			Set<Sport> sports = per.getSports();
			sports.forEach(sport->{
				System.out.println("Child1 :: "+sport);
			});
			//Access child2 objects
			Map<String,Medal> medals = per.getMedals();
			medals.forEach((type,medal)->{
				System.out.println("Child1 :: "+type+"...."+medal);
			});
		});

	}//run
}//class