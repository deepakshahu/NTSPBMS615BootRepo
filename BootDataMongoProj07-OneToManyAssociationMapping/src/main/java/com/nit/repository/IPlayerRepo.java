package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Player;

public interface IPlayerRepo extends MongoRepository<Player, Integer> {

}
