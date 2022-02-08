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
		/*//Prepare child objects
		PhoneNumber ph = new PhoneNumber();
		ph.setContactNo(7777777777L);
		ph.setNumberType("Office");
		ph.setProvider("BSNL");
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setContactNo(6666666666L);
		ph1.setNumberType("Residence");
		ph1.setProvider("Jio");
		//Prepare parent object
		Person per = new Person();
		per.setPname("Suraj");
		per.setPaddrs("Pune");
		per.setPhonesInfo(Set.of(ph,ph1));
		try {
			//Invoke the method
			System.out.println(service.saveDataUsingParent(per));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/

		//Call service class method for loading object
		//service.loadDataUsingParent();

		//Call service class method for deleting object
		//service.deleteParentAndItsChilds(1001);
		
		//Call service class method for deleting all PhoneNumbers of a Person
		service.deleteAllPhoneNumbersOfAPerson(1000);
	}//run
}//class