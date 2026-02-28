package com.julianavecchi.peoplemanagementapi.mapper;

import com.julianavecchi.peoplemanagementapi.dto.GameDTO;
import com.julianavecchi.peoplemanagementapi.model.GameModel;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameModel map(GameDTO gameDTO){
        GameModel gameModel = new GameModel();
        gameModel.setId(gameDTO.getId());
        gameModel.setName(gameDTO.getName());
        gameModel.setGenre(gameDTO.getGenre());
        gameModel.setPlatform(gameDTO.getPlatform());
        gameModel.setPeople(gameDTO.getPeople());
        return gameModel;
    }

    public GameDTO map(GameModel gameModel){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(gameModel.getId());
        gameDTO.setName(gameModel.getName());
        gameDTO.setGenre(gameModel.getGenre());
        gameDTO.setPlatform(gameModel.getPlatform());
        gameDTO.setPeople(gameModel.getPeople());
        return gameDTO;
    }
}

