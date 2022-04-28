package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
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

}
