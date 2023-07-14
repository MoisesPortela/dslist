package com.estudojava.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudojava.dslist.DTO.GameListDTO;
import com.estudojava.dslist.entities.GameList;
import com.estudojava.dslist.projections.GameMinProjection;
import com.estudojava.dslist.repositories.GameListRepository;
import com.estudojava.dslist.repositories.GameRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(response -> new GameListDTO(response)).toList();
		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection removedGame = list.remove(sourceIndex);
		list.add(destinationIndex, removedGame);
		//se o source index for menor, o source index é o valor do valor minimo
		int minValue = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
		int maxValue = sourceIndex < destinationIndex ? destinationIndex : sourceIndex ;
		
		for (int i = minValue; i<=maxValue;i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}
}
