package com.nit.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, String> {

}
