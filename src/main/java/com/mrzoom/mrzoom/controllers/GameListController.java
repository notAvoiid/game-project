package com.mrzoom.mrzoom.controllers;

import com.mrzoom.mrzoom.dto.GameListDto;
import com.mrzoom.mrzoom.dto.GameMinDto;
import com.mrzoom.mrzoom.services.GameListService;
import com.mrzoom.mrzoom.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
