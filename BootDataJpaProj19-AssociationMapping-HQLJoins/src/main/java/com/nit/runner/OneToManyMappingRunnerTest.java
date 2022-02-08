package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.service.IOneToManyMappingMgmtService;

@Component
public class OneToManyMappingRunnerTest implements CommandLineRunner {
	@Autowired
	private IOneToManyMappingMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.fetchDataByJoins().forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
	}//run
}//class