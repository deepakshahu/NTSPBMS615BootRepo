package com.nit.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nit.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, String> {
	
	//===================Entity Queries====================
	
	//@Query(fields="{}", value = "{nativePlace:?0}")  //to select all fields values   (or)
	@Query(value = "{nativePlace:?0}")
	public List<Tourist> getAllTouristsByNativePlace(String nativePlace);
	
	@Query(value = "{nativePlace:?0, age:{$gte:?1}}")  //applies nativePlace And age>=?
	public List<Tourist> getAllTouristsByNativePlaceAndAge(String nativePlace,float minAge);
	
	//@Query(value = "{age:{$gte:?0}, age:{$lte:?1}}")  //applies age>=? And age<=?
	@Query(value = "{age:{$gte:?0, $lte:?1}}")  //applies age>=? And age<=?
	public List<Tourist> getAllTouristsByAgeRange(float startAge, float endAge);
	
	@Query(value = "{$or:[{nativePlace:?0},{nativePlace:?1}]}")  //applies nativePlace1=? or nativePlace2=?
	public List<Tourist> getAllTouristsByNativePlaces(String nativePlace1, String nativePlace2);
	
	//=========Projections(Selecting specific single column or multiple column values===========
	
	@Query(fields = "{touristName:1, nativePlace:1, age:1}", value = "{nativePlace:?0}")
	//Gives select id, touristName, nativePlace, age from Tourist where nativePlace=?
	public List<Object[]> getTouristDataByNativePlace(String nativePlace);
	
	@Query(fields = "{id:0, touristName:1, nativePlace:1, age:1, contactNo:1}", value = "{nativePlace:{$in:[?0,?1,?2]}}")
	//Gives select touristName, nativePlace, age, contactNo from Tourist where nativePlace IN(?,?,?)
	public List<Object[]> getTouristDataByNativePlaces(String nativePlace1, String nativePlace2, String nativePlace3);
	
}
