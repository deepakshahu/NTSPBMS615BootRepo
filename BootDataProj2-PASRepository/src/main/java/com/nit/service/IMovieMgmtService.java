package com.nit.service;

import org.springframework.data.domain.Page;

import com.nit.entity.Movie;

public interface IMovieMgmtService {
	//One method can have only one var arg param that to last param of the method
	//Var args are internally arrays
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String ...properties);
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String ...properties);
	public void generateMoviesReport(int pageSize);
}
