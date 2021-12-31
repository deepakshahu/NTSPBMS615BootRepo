package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	@Autowired // Injects InMemory proxy class object
	private IMovieRepo movieRepo;

	@Override
	public String registerMovie(Movie movie) {
		System.out.println("InMemory Proxy class name : " + movieRepo.getClass() + "....."
				+ Arrays.toString(movieRepo.getClass().getInterfaces()));
		// Use Repo
		System.out.println("Before Saving :: " + movie);
		Movie movie1 = movieRepo.save(movie);
		System.out.println("After Saving :: " + movie1);
		return "Movie is registered with the ID value :: " + movie1.getMid();
	}

	@Override
	public long fetchMoviesCount() {
		System.out.println("InMemory Proxy class name : " + movieRepo.getClass() + "....."
				+ Arrays.toString(movieRepo.getClass().getInterfaces()));
		System.out.println("--------------------------------");
		System.out.println("Methods :: " + Arrays.toString(movieRepo.getClass().getDeclaredMethods()));
		return movieRepo.count();
	}

	@Override
	public boolean checkMovieById(Integer mid) {
		return movieRepo.existsById(mid);
	}

	@Override
	public Iterable<Movie> fetchAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Iterable<Movie> fetchAllMoviesByIds(List<Integer> mids) {
		return movieRepo.findAllById(mids);
	}

	/*@Override
	public Movie fetchMovieById(Integer mid) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Records not found");
	}*/

	/*@Override
	public Movie fetchMovieById(Integer mid) {
		return movieRepo.findById(mid).orElseThrow(()->new IllegalArgumentException("Record not found"));
	}*/

	@Override
	public Movie fetchMovieById(Integer mid) {
		return movieRepo.findById(mid).orElse(new Movie());// If record is available returns the Entity object with data
		// otherwise returns empty entity object
	}

	@Override
	public Optional<Movie> gatherMovieById(Integer mid) {
		Optional<Movie> opt = movieRepo.findById(mid);
		/*if(opt.isEmpty())
			return Optional.empty();
		else
			return opt;*/
		return opt.isEmpty() ?Optional.empty() :opt;
	}

	@Override
	public String groupMovieRegistration(List<Movie> moviesList) {
		Iterable<Movie> savedMovies = movieRepo.saveAll(moviesList);
		List<Integer> listIds = new ArrayList<>();
		if(savedMovies!=null && ((List<Movie>) savedMovies).size()>0) {
			savedMovies.forEach(m->{
				listIds.add(m.getMid());
			});
		}//if
		return listIds.toString()+" movies are saved";
	}

	@Override
	public String updateMovieDetails(Integer mid,  String newYear, Float newRating) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if(opt.isPresent()) {
			Movie movie = opt.get();
			movie.setYear(newYear);
			movie.setRating(newRating);
			movieRepo.save(movie);  //always calls merge() to perform update operation
			return mid+" movie id movie is updated";
		}
		else
			return mid+" movie id movie is not available";
	}

	/*@Override
	public String updateMovie(Movie movie) {
		Optional<Movie> opt = movieRepo.findById(movie.getMid());
		if(opt.isPresent()) {
			movieRepo.save(movie);
			return "Movie is updated";
		}
		else
			return "Movie not found to updated";
	}*/

	@Override
	public String updateMovie(Movie movie) {
		movieRepo.save(movie);
		return "Movie updated";
	}

	@Override
	public String removeMovieById(Integer mid) {
		Movie movie = movieRepo.findById(mid).orElseThrow(()->new IllegalArgumentException("Movie not found"));
		movieRepo.delete(movie);
		return "Record deleted";
	}

	@Override
	public String removeMovie(Movie movie) {
		Optional<Movie> opt = movieRepo.findById(movie.getMid());
		if(opt.isPresent()) {
			movieRepo.delete(movie);
			return "Movie deleted";
		}
		else
			return "Movie not found";
	}

	/*@Override
	public String removeMovie(Movie movie) {
		movieRepo.delete(movie);
		return "Record deleted";
	}*/

	@Override
	public String removeAllMovies() {
		long count = movieRepo.count();
		if(count!=0)
			movieRepo.deleteAll();
		return
				count+" no of records are deleted";
	}

	@Override
	public String removeAllMoviesById(List<Integer> ids) {
		
		Iterable<Movie> it = movieRepo.findAllById(ids);
		long count = ((List<Movie>) it).size();
		if(ids.size()!=0 && ids.size()==count) {
			movieRepo.deleteAllById(ids);
			return ((List<Movie>) it).size()+" no of records are deleted";
		}
		else 
			return " No ids are given to delete or either all or  some ids are not available to delete";
	}

}