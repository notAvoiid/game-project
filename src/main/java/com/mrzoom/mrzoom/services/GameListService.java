package com.mrzoom.mrzoom.services;

import com.mrzoom.mrzoom.dto.GameListDto;
import com.mrzoom.mrzoom.projections.GameMinProjection;
import com.mrzoom.mrzoom.repositories.GameListRepository;
import com.mrzoom.mrzoom.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		var result = gameListRepository.findAll();
		return result.stream().map(GameListDto::new).toList();
	}
	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex){
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for(int i = min; i <= max; i++){
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}

}
