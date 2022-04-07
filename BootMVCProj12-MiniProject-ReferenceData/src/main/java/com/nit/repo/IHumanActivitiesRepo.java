package com.nit.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nit.model.HumanActivities;

public interface IHumanActivitiesRepo extends CrudRepository<HumanActivities, String> {
	
	@Query("SELECT hobbies FROM HumanActivities")
	public Set<String> getAllHobbies();
	
	@Query("SELECT courses FROM HumanActivities")
	public Set<String> getAllCourses();
}
