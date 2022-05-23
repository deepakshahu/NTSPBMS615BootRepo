package com.nit.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nit.model.IPLTeam;

public interface IPLTeamRepo extends CrudRepository<IPLTeam, Integer> {
	
	@Query("SELECT * FROM DATA_JDBC_IPLTEAM WHERE TITLEWINNINGCOUNT>=:min AND TITLEWINNINGCOUNT<=:max")
	public List<IPLTeam> getTeamsByWinningCountRange(@Param("min") int startRange, @Param("max") int endRange);

}
