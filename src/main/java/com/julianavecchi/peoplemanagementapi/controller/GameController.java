package com.julianavecchi.peoplemanagementapi.controller;

import com.julianavecchi.peoplemanagementapi.dto.GameDTO;
import com.julianavecchi.peoplemanagementapi.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add")
    @Operation(
            summary = "Criar um novo jogo",
            description = "Recebe os dados de um jogo e realiza o cadastro no sistema, retornando uma mensagem de sucesso com o ID gerado."
    )
    public ResponseEntity<String> AddGame(@RequestBody GameDTO game){
        GameDTO gameDTO = gameService.AddGame(game);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Jogo criado com sucesso! " + gameDTO.getName() + " ID: " + gameDTO.getId());
    }

    @GetMapping("/list")
    @Operation(
            summary = "Listar todos os jogos",
            description = "Retorna uma lista com todos os jogos cadastrados no banco de dados."
    )
    public ResponseEntity<List<GameDTO>> ShowAllGame(){
        List<GameDTO>  listGames =  gameService.ShowAllGame();
        return ResponseEntity.ok(listGames);
    }

    @GetMapping("/list/{id}")
    @Operation(
            summary = "Buscar jogo por ID",
            description = "Retorna os dados de um jogo específico com base no ID informado. Caso não exista, retorna erro 404."
    )
    public ResponseEntity<?> ShowIdGame(@PathVariable Long id){
        if(gameService.ShowIdGame(id) != null){
            GameDTO game = gameService.ShowIdGame(id);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogo com ID: " + id + " não foi encontrado.");
        }
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Atualizar jogo",
            description = "Atualiza os dados de um jogo existente com base no ID informado. Retorna erro 404 caso o jogo não exista."
    )
    public ResponseEntity<String> UpdateGame(@PathVariable Long id, @RequestBody GameDTO game){
        if(gameService.ShowIdGame(id) != null){
            gameService.UpdateGame(id, game);
            return ResponseEntity.ok("O jogo de ID: " + id + " foi atualizado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogo com ID: " + id + " não foi encontrado.");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deletar jogo",
            description = "Remove um jogo do sistema com base no ID informado. Retorna erro 404 caso o jogo não exista."
    )
    public ResponseEntity<String> DeleteGame(@PathVariable Long id){
        if(gameService.ShowIdGame(id) != null){
            gameService.DeleteGame(id);
            return ResponseEntity.ok("Jogo com ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogo com ID: " + id + " não foi encontrado.");
        }

    }
}
