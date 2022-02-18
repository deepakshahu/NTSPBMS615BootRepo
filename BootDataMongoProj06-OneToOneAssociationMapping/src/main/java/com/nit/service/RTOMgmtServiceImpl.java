package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.document.DrivingLicense;
import com.nit.document.Person;
import com.nit.repository.IDrivingLicenseRepo;
import com.nit.repository.IPersonRepo;

@Service("rtoService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IDrivingLicenseRepo licenseRepo;

	@Override
	public String registerPersonWithDrivingLicense(Person person) {
		return "Person with Driving License is saved with id value :: "+personRepo.save(person).getPid();
	}

	@Override
	public List<Person> fetchAllPersonDetails() {
		return personRepo.findAll();
	}

	@Override
	public String registerDrivingLicenseWithPerson(DrivingLicense license) {
		return "Person with Driving License is saved with id value :: "+licenseRepo.save(license).getLicenseNo();
	}

	@Override
	public List<DrivingLicense> fetchAllDrivingLicenseDetails() {
		return licenseRepo.findAll();
	}

}
