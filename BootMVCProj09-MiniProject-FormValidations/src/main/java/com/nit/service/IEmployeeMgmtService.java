package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int no);
	public String editEmployee(Employee emp);
	public String deleteEmployee(int no);
}
