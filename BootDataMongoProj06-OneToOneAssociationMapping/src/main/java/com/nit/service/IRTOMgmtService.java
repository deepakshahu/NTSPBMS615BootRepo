package com.nit.service;

import java.util.List;

import com.nit.document.DrivingLicense;
import com.nit.document.Person;

public interface IRTOMgmtService {
	public String registerPersonWithDrivingLicense(Person person);
	public List<Person> fetchAllPersonDetails();
	public String registerDrivingLicenseWithPerson(DrivingLicense license);
	public List<DrivingLicense> fetchAllDrivingLicenseDetails();
}
