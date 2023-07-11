package com.estudojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.dslist.entities.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
	
}