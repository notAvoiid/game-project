package com.mrzoom.mrzoom.services;

import com.mrzoom.mrzoom.dto.GameListDto;
import com.mrzoom.mrzoom.dto.GameMinDto;
import com.mrzoom.mrzoom.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		var result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDto(x)).toList(); //(GameListDto::new)
	}

}
