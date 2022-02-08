package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
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

	@Override
	public void loadDataUsingParent() {
		List<Person> list = personRepo.findAll();
		list.forEach(per->{
			System.out.println("Parent :: "+per);
			//Get childs for each parent
			Set<PhoneNumber> childs = per.getPhonesInfo();
			childs.forEach(ph->{
				System.out.println("Child :: "+ph);
			});
		});
	}//method

	@Override
	public String deleteParentAndItsChilds(int pid) {
		//Load Parent object
		Optional<Person> opt = personRepo.findById(pid);  //Here along with Parent object, the associated child objects will be loaded
		if(opt.isPresent()) {
			personRepo.delete(opt.get());  //Here, if we delete parent object, the associated child objects will be deleted
			return "Person and his PhoneNumbers are deleted";
		}
		else {
			return "Person not found";
		}//else
	}//method
	
	@Override
	public String deleteAllPhoneNumbersOfAPerson(int pid) {
		//Load Parent object
		Optional<Person> opt = personRepo.findById(pid);  //Here along with Parent object, the associated child objects will be loaded
		if(opt.isPresent()) {
			//Get childs of a parent
			Set<PhoneNumber> childs = opt.get().getPhonesInfo();
			/*childs.forEach(ph->{
				phoneRepo.delete(ph);
			});*/
			phoneRepo.deleteAll(childs);
			return "All childs(PhoneNumbers) of a Person are deleted";
		}
		else {
			return "Person not found";
		}
	}//method
}//class