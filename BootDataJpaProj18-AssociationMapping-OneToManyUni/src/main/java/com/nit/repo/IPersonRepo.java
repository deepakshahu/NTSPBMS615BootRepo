package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
