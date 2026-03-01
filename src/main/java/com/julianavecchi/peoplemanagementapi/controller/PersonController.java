package com.julianavecchi.peoplemanagementapi.controller;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/add")
    @Operation(
            summary = "Criar uma nova pessoa",
            description = "Recebe os dados de uma pessoa e realiza o cadastro no sistema, retornando uma mensagem de sucesso com o ID gerado."
    )
    public ResponseEntity<String> AddPerson(@RequestBody PersonDTO person){
        PersonDTO personDTO = personService.AddPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa criada com sucesso! " + personDTO.getName() + " ID: " + personDTO.getId());

    }

    @GetMapping("/list")
    @Operation(
            summary = "Listar todas as pessoas",
            description = "Retorna uma lista com todas as pessoas cadastradas no banco de dados."
    )
    public ResponseEntity<List<PersonDTO>> ShowAllPeople(){
        List<PersonDTO>  listPeople =  personService.ShowAllPeople();
        return ResponseEntity.ok(listPeople);
    }

    @GetMapping("/list/{id}")
    @Operation(
            summary = "Buscar pessoa por ID",
            description = "Retorna os dados de uma pessoa específica com base no ID informado. Caso não exista, retorna erro 404."
    )
    public ResponseEntity<?> ShowIdPerson(@PathVariable Long id){
        if(personService.ShowIdPerson(id) != null){
            PersonDTO person = personService.ShowIdPerson(id);
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa com ID: " + id + " não foi encontrada.");
        }

    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Atualizar pessoa",
            description = "Atualiza os dados de uma pessoa existente com base no ID informado. Retorna erro 404 caso a pessoa não exista."
    )
    public ResponseEntity<String> UpdatePerson(@PathVariable Long id, @RequestBody PersonDTO person){
        if(personService.ShowIdPerson(id) != null){
            personService.UpdatePerson(id, person);
            return ResponseEntity.ok("A pessoa de ID: " + id + " foi atualizada com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa com ID: " + id + " não foi encontrada.");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deletar pessoa",
            description = "Remove uma pessoa do sistema com base no ID informado. Retorna erro 404 caso a pessoa não exista."
    )
    public ResponseEntity<String> DeletePerson(@PathVariable Long id){
        if(personService.ShowIdPerson(id) != null){
            personService.DeletePerson(id);
            return ResponseEntity.ok("Pessoa com ID: " + id + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa com ID: " + id + " não foi encontrada.");
        }
    }
}
