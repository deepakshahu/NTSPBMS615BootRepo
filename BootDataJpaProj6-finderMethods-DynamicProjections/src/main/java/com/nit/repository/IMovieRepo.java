package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Movie;
import com.nit.view.View;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	public <T extends View> Iterable<T> findByMnameIn(List<String> movies0, Class<T> clazz);
}
