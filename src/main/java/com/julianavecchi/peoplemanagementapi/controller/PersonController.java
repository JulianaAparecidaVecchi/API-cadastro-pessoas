package com.julianavecchi.peoplemanagementapi.controller;

import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import com.julianavecchi.peoplemanagementapi.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/add")
    public String AddPerson(){
        return "Pessoa adicionada com sucesso!";
    }
    @GetMapping("/all")
    public List<PersonModel> ShowAllPeople(){
        return personService.ShowAllPeople();
    }

    @PutMapping("/update")
    public String UpdatePerson(){
        return "Pessoa atualizada com sucesso!";
    }

    @DeleteMapping("/delete")
    public String DeletePerson(){
        return "Pessoa deletada com sucesso!";
    }
}
