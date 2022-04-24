package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repo.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
	

}
