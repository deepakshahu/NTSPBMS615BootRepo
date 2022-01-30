package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.EmployeeInfo;

public interface IEmployeeInfoRepo extends JpaRepository<EmployeeInfo, Integer> {

}
