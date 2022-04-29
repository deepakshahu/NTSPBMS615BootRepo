package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
