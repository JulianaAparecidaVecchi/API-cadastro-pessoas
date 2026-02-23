package com.julianavecchi.peoplemanagementapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {

    @PostMapping("/add")
    public String AddGame(){
        return "Jogo adicionado com sucesso!";
    }

    @GetMapping("/all")
    public String ShowAllGame(){
        return "Jogos listados com sucesso!";
    }

    @PutMapping("/update")
    public String UpdateGame(){
        return "Jogo atualizado com sucesso!";
    }

    @DeleteMapping("/delete")
    public String DeleteGame(){
        return "Jogo deletado com sucesso!";
    }
}
