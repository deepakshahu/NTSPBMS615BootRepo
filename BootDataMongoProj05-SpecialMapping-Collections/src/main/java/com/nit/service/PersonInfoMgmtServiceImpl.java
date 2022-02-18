package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.document.PersonInfo;
import com.nit.repo.IPersonInfoRepo;

@Service("personService")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService{
	@Autowired
	private IPersonInfoRepo personRepo;

	@Override
	public String registerPerson(PersonInfo info) {
		return "Person is saved with :: "+personRepo.save(info).getPid();
	}

	@Override
	public List<PersonInfo> fetchAllPersons() {
		return personRepo.findAll();
	}

	@Override
	public String savePersonGroup(List<PersonInfo> info) {
		int count = personRepo.saveAll(info).size();
		return count+" no of person are saved";
	}

	@Override
	public List<PersonInfo> fetchAllPersons(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		return personRepo.findAll(sort);
	}

	@Override
	public Optional<PersonInfo> fetchPersonById(Integer id) {
		Optional<PersonInfo> opt = personRepo.findById(id);
		return opt;
	}
	
	@Override
	public String modifyPersonInfoById(Integer id, List<String> friends) {
		Optional<PersonInfo> opt = personRepo.findById(id);
		if(opt.isPresent()) {
			PersonInfo info = opt.get();
			info.setFriends(friends);
			return personRepo.save(info).getPid()+" is updated with new friends";
		}
		else
			return "Document not found to update";
	}
	
	@Override
	public String removePersonInfoById(Integer id) {
		Optional<PersonInfo> opt = personRepo.findById(id);
		if(opt.isPresent()) {
			PersonInfo info = opt.get();
			personRepo.delete(info);
			return "Document is found and deleted";
		}
		else
			return "Document not found to delete";
	}
	
}//class