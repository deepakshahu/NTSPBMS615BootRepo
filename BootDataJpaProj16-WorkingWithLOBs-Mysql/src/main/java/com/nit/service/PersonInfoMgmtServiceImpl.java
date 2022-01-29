package com.nit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.PersonInfo;
import com.nit.repo.IPersonInfoRepo;

@Service("personService")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {
	
	@Autowired
	private IPersonInfoRepo repo;

	@Override
	public String registerPerson(PersonInfo info) {
		return repo.save(info).getPid()+" id person is saved";
	}
	
	@Override
	public PersonInfo fetchPersonDetailsById(int pid) {
		Optional<PersonInfo> opt = repo.findById(pid);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

}
