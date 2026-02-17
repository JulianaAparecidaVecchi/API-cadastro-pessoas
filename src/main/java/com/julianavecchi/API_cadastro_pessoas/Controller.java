package com.julianavecchi.API_cadastro_pessoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/HelloWorld")
    public String HellowWorld(){
        return "Essa é minha primeira mensagem nessa rota.";
    }
}
