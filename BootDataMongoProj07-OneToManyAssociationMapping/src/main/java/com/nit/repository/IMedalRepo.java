package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Medal;

public interface IMedalRepo extends MongoRepository<Medal, String> {

}
