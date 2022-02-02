package com.nit.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.service.IOneToManyMappingMgmtService;

@Component
public class OneToManyMappingRunnerTest implements CommandLineRunner {
	@Autowired
	private IOneToManyMappingMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//Prepare child objects
		PhoneNumber ph = new PhoneNumber();
		ph.setContactNo(99999999999L);
		ph.setNumberType("Office");
		ph.setProvider("Airtel");
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setContactNo(8888888888L);
		ph1.setNumberType("Residence");
		ph1.setProvider("VI");
		//Prepare parent object
		Person per = new Person();
		per.setPname("Deepak");
		per.setPaddrs("Mumbai");
		per.setPhonesInfo(Set.of(ph,ph1));
		try {
			//Invoke the method
			System.out.println(service.saveDataUsingParent(per));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//run
}//class