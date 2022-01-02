package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	@Autowired // Injects InMemory proxy class object
	private IMovieRepo movieRepo;

	@Override
	public String removeMoviesByIds(List<Integer> ids) {
		List<Movie> list = movieRepo.findAllById(ids);
		long count = list.size();
		movieRepo.deleteAllByIdInBatch(ids);
		return count+" No of records are deleted";
	}

	@Override
	public List<Movie> searchAllMoviesByIds(List<Integer> ids) {
		return movieRepo.findAllById(ids);
	}

	@Override
	public List<Movie> searchMoviesByMovie(Movie movie, boolean asc, String... props) {
		Example example = Example.of(movie);
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		List<Movie> list = movieRepo.findAll(example, sort);
		return list;
	}

	@Override
	public Movie searchMovieById(Integer id) {
		Movie movie = movieRepo.getById(id);
		return movie;
	}

}//class