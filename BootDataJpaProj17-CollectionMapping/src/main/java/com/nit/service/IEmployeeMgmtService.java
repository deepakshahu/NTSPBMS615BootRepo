package com.nit.service;

import java.util.List;

import com.nit.entity.EmployeeInfo;

public interface IEmployeeMgmtService {
	public String registerEmployee(EmployeeInfo info);
	public List<EmployeeInfo> getAllEmpDetails();
}