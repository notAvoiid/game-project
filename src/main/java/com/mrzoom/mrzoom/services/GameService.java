package com.mrzoom.mrzoom.services;

import com.mrzoom.mrzoom.dto.GameMinDto;
import com.mrzoom.mrzoom.entities.Game;
import com.mrzoom.mrzoom.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService{

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList(); //(GameMinDto::new)
    }

}