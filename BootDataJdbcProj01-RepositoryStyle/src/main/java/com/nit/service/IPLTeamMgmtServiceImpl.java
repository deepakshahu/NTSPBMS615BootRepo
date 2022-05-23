package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.IPLTeam;
import com.nit.repository.IPLTeamRepo;

@Service("IPLTeamService")
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {

	@Autowired
	private IPLTeamRepo teamRepo;
	
	@Override
	public String registerTeam(IPLTeam team) {
		return "Team is registered/updated with id :: "+teamRepo.save(team).getTeamid();
	}

	@Override
	public Iterable<IPLTeam> getAllTeams() {
		return teamRepo.findAll();
	}

	@Override
	public List<IPLTeam> fetchTeamsByTitleWinningCountRange(int startRange, int endRange) {
		return teamRepo.getTeamsByWinningCountRange(startRange, endRange);
	}

}
