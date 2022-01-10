package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Movie;
import com.nit.view.ResultView;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	public Iterable<ResultView> findByMidGreaterThanEqualAndMidLessThanEqual(int startMid, int endMid);
}
