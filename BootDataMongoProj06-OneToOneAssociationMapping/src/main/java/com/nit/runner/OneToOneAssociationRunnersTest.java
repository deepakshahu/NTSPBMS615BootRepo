package com.nit.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.DrivingLicense;
import com.nit.document.Person;
import com.nit.service.IRTOMgmtService;

@Component
public class OneToOneAssociationRunnersTest implements CommandLineRunner {
	@Autowired
	private IRTOMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
				System.out.println("======save()====Parent to Child=============");
				try {
					Person person = new Person(new Random().nextInt(10000), "Deepak", "Mumbai");
					DrivingLicense license = new DrivingLicense(Long.valueOf(new Random().nextInt(100000000)) , "Two-Wheeler", LocalDate.of(2026, 11, 15));
					//Child to parent
					person.setLicenseDetails(license);
					System.out.println(service.registerPersonWithDrivingLicense(person));
				}
				catch(Exception e) {
					e.printStackTrace();
				}

				System.out.println("=======findAll()====Parent to Child============");
				service.fetchAllPersonDetails().forEach(per->{
					System.out.println("Parent :: "+per);
					DrivingLicense license = per.getLicenseDetails();
					System.out.println("Child :: "+license);
				});
		 */

		System.out.println("======save()====Child to Parent=============");
		try {
			Person person = new Person(new Random().nextInt(10000), "Suraj", "Pune");
			DrivingLicense license = new DrivingLicense(Long.valueOf(new Random().nextInt(100000000)) , "Three-Wheeler", LocalDate.of(2030, 10, 13));
			//Parent to child
			license.setPersonDetails(person);
			System.out.println(service.registerDrivingLicenseWithPerson(license));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("=======findAll()====Child to Parent============");
		service.fetchAllDrivingLicenseDetails().forEach(lic->{
			System.out.println("Child :: "+lic);
			Person person = lic.getPersonDetails();
			System.out.println("Parent :: "+person);
		});

	}//run
}//class