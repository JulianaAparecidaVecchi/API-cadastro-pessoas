package com.julianavecchi.peoplemanagementapi.service;

import com.julianavecchi.peoplemanagementapi.dto.GameDTO;
import com.julianavecchi.peoplemanagementapi.mapper.GameMapper;
import com.julianavecchi.peoplemanagementapi.model.GameModel;
import com.julianavecchi.peoplemanagementapi.repository.GameRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameService(GameRepository gameRepository ,GameMapper gameMapper){
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public GameDTO AddGame(GameDTO gameDTO){
        GameModel game = gameMapper.map(gameDTO);
        game = gameRepository.save(game);
        return gameMapper.map(game);
    }

    public List<GameDTO> ShowAllGame(){
        List<GameModel> game = gameRepository.findAll();
        return game.stream()
                .map(gameMapper::map)
                .collect(Collectors.toList());
    }

    public GameDTO ShowIdGame(Long id){
        Optional<GameModel> gameId = gameRepository.findById(id);
        return gameId.map(gameMapper::map).orElse(null);
    }

    public void DeleteGame(Long id){
        gameRepository.deleteById(id);
    }

    public GameDTO UpdateGame(Long id, GameDTO gameDTO){
        Optional<GameModel> gameId = gameRepository.findById(id);
        if(gameId.isPresent()){
            GameModel gameUpdate = gameMapper.map(gameDTO);
            gameUpdate.setId(id);
            GameModel gameSave = gameRepository.save(gameUpdate);
            return gameMapper.map(gameSave);
        }
        return null;
    }
}
