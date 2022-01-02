package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

}
