package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nit.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	//===========Entity Queries (Selecting all column values)==============
	//@Query("from Movie where mid>=?1 and mid<=?2")
	//@Query("from Movie as m where m.mid>=?1 and m.mid<=?2")  //m is alias name which is optional
	//public List<Movie> searchMoviesByIdRange(int start, int end);

	/*@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(@Param("min") int start, @Param("max") int end);*/

	@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(int min, int max);
	
	@Query("from Movie where mname In(:name1, :name2, :name3) order by mname asc")
	public List<Movie> searchMoviesByMnames(String name1, String name2, String name3);  //taking array/var args/collection params for multiple
	                                                            //(or)                                                             											    	//named params or positional params is not allowed
	@Query("from Movie where mname In(?1,?2,?3) order by mname asc")
	public List<Movie> searchMoviesByMnames1(String name1, String name2, String name3);
	
	//===========Scalar Queries(Selecting specific multiple column values)==============
	@Query("select mid,mname,year from Movie where rating>=:rat and year in(:y1,:y2,:y3)")
	public List<Object[]> fetchMovieDetailsByRatingsAndYear(float rat, String y1, String y2, String y3);
	
	//===========Scalar Queries (Selecting specific single column values)==============
	@Query("select mname from Movie where year>=:start and year<=:end order by mname desc")
	public List<String> fetchMoviesByYearRange(String start, String end);
}
