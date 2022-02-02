package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Person;
import com.nit.repo.IPersonRepo;
import com.nit.repo.IPhoneNumberRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IPhoneNumberRepo phoneRepo;

	@Override
	public String saveDataUsingParent(Person person) {
		return personRepo.save(person).getPid()+" Person is saved";		
	}
}