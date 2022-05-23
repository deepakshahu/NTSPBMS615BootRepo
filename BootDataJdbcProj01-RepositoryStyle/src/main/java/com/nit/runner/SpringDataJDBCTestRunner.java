package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.IPLTeam;
import com.nit.service.IIPLTeamMgmtService;

@Component
public class SpringDataJDBCTestRunner implements CommandLineRunner {
	
	@Autowired
	private IIPLTeamMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//save operation
		/*IPLTeam team = new IPLTeam(1002, "MI", "WilliamSon", "Modi",  10, true);
		System.out.println(service.registerTeam(team));*/
		
		//select operation
		//service.getAllTeams().forEach(System.out::println);
		
		//select operation using custom method
		service.fetchTeamsByTitleWinningCountRange(1, 10).forEach(System.out::println);
	}

}
