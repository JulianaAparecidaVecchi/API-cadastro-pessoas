package com.julianavecchi.peoplemanagementapi.controller;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.mapper.PersonMapper;
import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import com.julianavecchi.peoplemanagementapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> AddPerson(@RequestBody PersonDTO person){
        PersonDTO personDTO = personService.AddPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa criada com sucesso! " + personDTO.getName() + " ID: " + personDTO.getId());

    }

    @GetMapping("/list")
    public ResponseEntity<List<PersonDTO>> ShowAllPeople(){
        List<PersonDTO>  listPeople =  personService.ShowAllPeople();
        return ResponseEntity.ok(listPeople);
    }

    @GetMapping("/list/{id}")
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
