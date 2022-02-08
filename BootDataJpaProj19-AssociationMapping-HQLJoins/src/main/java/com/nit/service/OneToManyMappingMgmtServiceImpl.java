package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.repo.IPersonRepo;
import com.nit.repo.IPhoneNumberRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {
	
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IPhoneNumberRepo phoneRepo;

	@Override
	public List<Object[]> fetchDataByJoins() {
		return personRepo.getDataByJoins();
	}//method
}//class