package com.nit.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, Integer> {
	
	public List<Tourist> findByNativePlaceOrderByTouristNameAsc(String nativePlace);
	public Tourist findByContactNo(Long contactNo);
}
