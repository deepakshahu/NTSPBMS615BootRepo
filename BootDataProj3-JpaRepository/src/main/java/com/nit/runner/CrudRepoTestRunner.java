package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		/*System.out.println("-------------deleteAllByIdInBatch for deleting all object by given ids in Batch Operation------");
		try {
			//System.out.println(service.removeMoviesByIds(List.of(31,89)));
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(32);
			ids.add(null);
			List<Integer> ids = Arrays.asList(33,null);
			System.out.println(service.removeMoviesByIds(ids));
		}
		catch(NullPointerException nfe) {
			System.out.println("Ids must not be null");
			nfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("------for--findAllById() method------");
		try {
			List<Integer> idsList = new ArrayList<Integer>();
			idsList.add(27);
			idsList.add(28);
			System.out.println("Movies are :: "+service.searchAllMoviesByIds(idsList));
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Movies are :: "+service.searchAllMoviesByIds(List.of(27,28,29,30)));  ///from java 9 //returned instances are immutable.
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Movies are :: "+service.searchAllMoviesByIds(Arrays.asList(27,28,29)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--findAll(Example, Sort) method------");
		try {
			Movie movie = new Movie();
			movie.setMid(29);
			//movie.setMname("Atrangi Re");
			movie.setRating(4.9f);
			movie.setYear("2022");
			List<Movie> list = service.searchMoviesByMovie(movie, true, "mname");
			list.forEach(System.out::println);
		}//try 
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("------for--getById(Integer id) -- method------");
		try {
			System.out.println("27 Movie details are :: "+service.searchMovieById(27));
		}//try 
		catch (Exception e) {
			e.printStackTrace();
		}

	}// run
}// class