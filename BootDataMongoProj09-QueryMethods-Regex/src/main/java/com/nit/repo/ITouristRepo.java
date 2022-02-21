package com.nit.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nit.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, String> {
	
	//=========Using Regex=============
	
	@Query(value = "{nativePlace:{$regex:?0}}")
	public List<Tourist> getTouristByNativePlaceRegex(String nativePlace);
	
	//==========Using count==============
	@Query(value = "{age:{$gte:?0, $lte:?1}}", count = true)
	public int getTouristsCountByAgeRange(float minAge, float maxAge);
	
	//==========Using sort=============
	@Query(value = "{}", sort = "{touristName:1}")  //1 means ASC and -1 means DESC, {} indicates no condition
	public List<Tourist> getAllTouristsSortedByName();
	
	@Query(value = "{contactNo:null}" ,delete = true)
	public int deleteTouristsWithNoContactNumber();
	
	@Query(value = "{isVaccinated:false}", exists = true)
	public boolean isTouristsExistWithOutVaccination();
}