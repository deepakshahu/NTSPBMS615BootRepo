package com.nit.service;

import java.util.List;

import com.nit.model.IPLTeam;

public interface IIPLTeamMgmtService {
	public String registerTeam(IPLTeam team);
	public Iterable<IPLTeam> getAllTeams();
	public List<IPLTeam> fetchTeamsByTitleWinningCountRange(int startRange, int endRange);
}
