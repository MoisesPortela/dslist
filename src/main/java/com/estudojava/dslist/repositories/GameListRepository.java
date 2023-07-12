package com.estudojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.dslist.entities.GameList;


public interface GameListRepository extends JpaRepository<GameList, Long> {
	
}