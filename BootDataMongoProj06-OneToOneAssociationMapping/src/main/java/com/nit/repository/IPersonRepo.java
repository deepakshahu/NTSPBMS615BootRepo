package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Person;

public interface IPersonRepo extends MongoRepository<Person, Integer> {

}
