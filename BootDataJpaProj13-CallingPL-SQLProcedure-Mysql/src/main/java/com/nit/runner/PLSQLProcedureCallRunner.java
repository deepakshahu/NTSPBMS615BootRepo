package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.service.IEmployeeMgmtService;

@Component
public class PLSQLProcedureCallRunner implements CommandLineRunner{
	
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		/*service.fetchEmpDetailsByDesgs("CLERK", "MANAGER").forEach(emp->{
			System.out.println(emp);
		});*/
		
		service.fetchEmpDetailsByDesgs("CLERK", "MANAGER").forEach(System.out::println);
	}//run
}//class