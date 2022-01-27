package com.nit.service;

import java.util.List;

import com.nit.entity.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmpDetailsByDesgs(String desg1, String desg2);
}