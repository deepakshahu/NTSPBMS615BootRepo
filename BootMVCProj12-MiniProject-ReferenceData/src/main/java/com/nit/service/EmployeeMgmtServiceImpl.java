package com.nit.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repo.IEmployeeRepo;
import com.nit.repo.IHumanActivitiesRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;
	@Autowired
	private IHumanActivitiesRepo humanRepo;
	@Autowired
	private Environment env;

	@Override
	public Page<Employee> getEmployeesPageData(Pageable pageable) {
		Page<Employee> page = empRepo.findAll(pageable);
		return page;
	}

	@Override
	public String registerEmployee(Employee emp) {
		int idVal = empRepo.save(emp).getEmpno();
		return "Employee is saved with id value :: "+idVal;
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = empRepo.findById(no).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
		int idVal = empRepo.save(emp).getEmpno();
		return idVal+" Employee is updated";
	}

	@Override
	public String deleteEmployee(int no) {
		empRepo.deleteById(no);
		return no+" emp no employee is deleted";
	}

	@Override
	public Set<String> getAllCountries() {
		//get all Locales of the world
		Locale locales[] = Locale.getAvailableLocales();
		Set<String> countrySet = new TreeSet<String>();
		for(Locale l:locales) {
			if(l!=null)
			countrySet.add(l.getDisplayCountry());
		}
		return countrySet; 
	}
	
	@Override
	public List<String> getStatesByCountry(String country) {
		//get states of country through Environment object
		String statesInfo = env.getRequiredProperty(country);
		//convert comma separated values into List collection using "," as delimeter
		List<String> statesList = Arrays.asList(statesInfo.split(","));
		//sort the collection
		Collections.sort(statesList);
		return statesList;
	}
	
	@Override
	public Set<String> getAllHobbies() {
		return humanRepo.getAllHobbies();
	}
	
	@Override
	public Set<String> getAllCourses() {
		return humanRepo.getAllCourses();
	}

}
