package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		/*System.out.println("--------------findAll(Sort sort)--------------");
		Iterable<Movie> it = service.displayMoviesByOrder(false, "year", "mname");
		it.forEach(System.out::println);*/

		/*System.out.println("-------------findAll(Pageable pageable)----------");
		try {
			Page<Movie> page = service.generateReport(2, 3, true, "mname");
			System.out.println("Page Number :: "+page.getNumber());
			System.out.println("Pages count :: "+page.getTotalPages());
			System.out.println("Is it first page :: "+page.isFirst());
			System.out.println("Is it last page :: "+page.isLast());
			System.out.println("Page size :: "+page.getSize());
			System.out.println("Page Elements count :: "+page.getNumberOfElements());
			if(!page.isEmpty()) {
				List<Movie> list = page.getContent();
				list.forEach(System.out::println);
			}
			else
				System.out.println("No page found");
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("-------------findAll(Pageable pageable)----------");
		try {
			service.generateMoviesReport(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//run
}//class