package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,	 properties);
		return movieRepo.findAll(sort);
	}

	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props) {
		//Create Pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(asc?Direction.ASC:Direction.DESC, props));

		//Get requested page records
		Page<Movie> page = movieRepo.findAll(pageable);
		return page;
	}

	@Override
	public void generateMoviesReport(int pageSize) {
		//Get count of records
		long recordsCount = movieRepo.count();

		long pagesCount=0;
		if(pageSize>=1) {
			//Decide no of pages(pagesCount)
			pagesCount = recordsCount/pageSize;
			//Get exact pagesCount
			pagesCount = recordsCount%pageSize==0?pagesCount:++pagesCount;
		}
		else
			throw new IllegalArgumentException("Page Size cannot be zero or negative number");

		for(int pageNo=0; pageNo<pagesCount; ++pageNo) {
			//Prepare pageable object
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			Page<Movie> page = movieRepo.findAll(pageable);
			System.out.println("---Page no :: "+(pageNo+1)+" "+" Page size :: "+pageSize+" Page records count :: "+page.getNumberOfElements());
			List<Movie> list = page.getContent();
			list.forEach(movie->{
				System.out.println(movie);
			});
		}//for
	}//method

}//class