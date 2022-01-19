package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nit.model.Movie;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	@Query("update Movie set rating=:newRating where mname=:name")
	@Modifying
	public int modifyRatingByMovieName(float newRating, String name);
	
	@Query("delete from Movie where year>=:start and year<=:end")
	@Modifying
	public int deleteMovieByYearRange(String start, String end);
}