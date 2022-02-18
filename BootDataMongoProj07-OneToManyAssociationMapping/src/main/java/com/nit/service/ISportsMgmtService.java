package com.nit.service;

import java.util.List;

import com.nit.document.Player;

public interface ISportsMgmtService {
	public String registerPlayerWithSportsAndMedals(Player player);
	public List<Player> fetchAllPlayersInfo();
}
