package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.PersonInfo;

public interface IPersonInfoRepo extends JpaRepository<PersonInfo, Integer> {

}
