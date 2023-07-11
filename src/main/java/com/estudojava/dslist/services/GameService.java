package com.estudojava.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudojava.dslist.DTO.GameMinDTO;
import com.estudojava.dslist.entities.Game;
import com.estudojava.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(response -> new GameMinDTO(response)).toList();
		
	}
}
