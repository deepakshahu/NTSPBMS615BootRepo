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
		/*//Invoke service method
		System.out.println("------for--save()--method-------");
		Movie movie = new Movie();
		movie.setMname("Golmal");
		movie.setYear("2008");
		movie.setRating(4.3f);
		try{
			System.out.println(service.registerMovie(movie));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("-------------count()-------------------");
		try {
			System.out.println("Records count :: "+service.fetchMoviesCount());
		}
		catch(Exception e){
			e.printStackTrace();
		}*/

		/*System.out.println("------for--existsById()--method-------");
		 try {
			System.out.println("Is 1st mid movie available :: "+service.checkMovieById(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("------for--findAll()--method-------");
		try {
			Iterable<Movie> list = service.fetchAllMovies();
			for(Movie movie:list) {  //Enhanced for loop
				System.out.println(movie);
			}
			System.out.println("-------------------------------------------------------------------");
			list.forEach(movie->{  //forEach() method
				System.out.println(movie);
			});
			System.out.println("-------------------------------------------------------------------");
			list.forEach(movie->System.out.println(movie));  //forEach() method
			System.out.println("-------------------------------------------------------------------");
			list.forEach(System.out::println);  //forEach() method+static method reference
			System.out.println("-------------------------------------------------------------------");
			Arrays.asList(list).stream().forEach(System.out::println);  //forEach() method+streaming api+static method reference
			System.out.println("-------------------------------------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("------for--findAllById()--method-------");
		try {
			List<Integer> idsList = new ArrayList<>();
			idsList.add(1);
			idsList.add(2);
			System.out.println("Movies are :: "+service.fetchAllMoviesByIds(idsList));
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Movies are :: "+service.fetchAllMoviesByIds(List.of(1,2)));  //from java 9 //returned instances are immutable.
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Movies are :: "+service.fetchAllMoviesByIds(Arrays.asList(1,2)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("------for--findById()--method-------");
		 try {
			System.out.println("1st Movie is :: "+service.findMovieById(12));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/

		/*System.out.println("------for--findById()--method-------");
		try {
			System.out.println("1st Movie is :: "+service.fetchMovieById(18));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/

		/*System.out.println("------for--findById()--method-------");
		try {
			Optional<?> opt = service.gatherMovieById(1);
			if(!opt.isEmpty())
				System.out.println("1st Movie is :: "+opt.get());
			else
				System.out.println("Record not found");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/

		/*System.out.println("------for--saveAll()--method-------");
		try {
			String result = service.groupMovieRegistration(List.of(new Movie("Atrangi Re","2021",4.1f),  //Java 9 feature
					new Movie("83","2021",4.6f),
					new Movie("Pushpa","2021",4.0f) ));
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--save()--method-for-update-object-operation---");
		try {
			String result = service.updateMovieDetails(23, "1999", 3.9f);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--save()--method-for-update-object-operation---");
		try {
			Movie movie = new Movie("Chai2","2010",3.5f);
			movie.setMid(25);
			String result = service.updateMovie(movie);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--deleteById()-for delete-object-method-operation---");
		try {
			System.out.println(service.removeMovieById(25));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--delete()-for delete-object--method-operation---");
		try {
			Movie movie = new Movie();
			movie.setMid(23);
			System.out.println(service.removeMovie(movie));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("------for--deleteAll()-for deleting all-objects-operation---");
		try {
			System.out.println(service.removeAllMovies());
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("------for--deleteAllById()-for deleting all by id-objects-operation---");
		try {
			System.out.println(service.removeAllMoviesById(List.of(27,28)));
		}
		catch(NullPointerException npe) {
			System.out.println("ids must not be null");
			npe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//run
}//class