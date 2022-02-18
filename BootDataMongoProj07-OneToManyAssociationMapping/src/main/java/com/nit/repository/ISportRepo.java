package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Sport;

public interface ISportRepo extends MongoRepository<Sport, Integer> {

}
