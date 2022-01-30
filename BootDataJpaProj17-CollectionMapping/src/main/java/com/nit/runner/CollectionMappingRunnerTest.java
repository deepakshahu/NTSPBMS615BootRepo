package com.nit.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.EmployeeInfo;
import com.nit.service.IEmployeeMgmtService;

@Component
public class CollectionMappingRunnerTest implements CommandLineRunner {
	
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*//Save object
		try {
			//Prepare object
			EmployeeInfo info = new EmployeeInfo(null, "deepak", List.of("Harsh","Deepraj","Hiren"), Set.of(9999999L,8888888L), Map.of("Aadhar","869228316887","VoterId","7854GFR8"));
			System.out.println(service.registerEmployee(info));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("----------------All Emp Details are :: -----------------");
		//Retrieve object
		service.getAllEmpDetails().forEach(System.out::println);
	}//run
}//class