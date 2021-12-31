package com.nit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Movie;

public interface IMovieRepo extends CrudRepository<Movie, Integer> {

}
