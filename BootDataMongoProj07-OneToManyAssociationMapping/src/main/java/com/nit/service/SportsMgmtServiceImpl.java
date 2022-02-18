package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.document.Player;
import com.nit.repository.IMedalRepo;
import com.nit.repository.IPlayerRepo;
import com.nit.repository.ISportRepo;

@Service("sportService")
public class SportsMgmtServiceImpl implements ISportsMgmtService {
	
	@Autowired
	private IPlayerRepo playerRepo;
	@Autowired
	private ISportRepo sportRepo;
	@Autowired
	private IMedalRepo medalRepo;

	@Override
	public String registerPlayerWithSportsAndMedals(Player player) {
		return "Player with sports and medals info is saved with :: "+playerRepo.save(player).getPid()+" id value";
	}

	@Override
	public List<Player> fetchAllPlayersInfo() {
		return playerRepo.findAll() ;
	}

}
