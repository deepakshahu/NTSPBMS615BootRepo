package com.nit.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.PersonInfo;

public interface IPersonInfoRepo extends MongoRepository<PersonInfo, Integer> {
	
}
