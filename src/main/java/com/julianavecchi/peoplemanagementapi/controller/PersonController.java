package com.julianavecchi.peoplemanagementapi.controller;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.mapper.PersonMapper;
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
    public PersonDTO AddPerson(@RequestBody PersonDTO person){
        return personService.AddPerson(person);
    }

    @GetMapping("/list")
    public List<PersonDTO> ShowAllPeople(){
        return personService.ShowAllPeople();
    }

    @GetMapping("/list/{id}")
    public PersonDTO ShowIdPerson(@PathVariable Long id){
        return personService.ShowIdPerson(id);
    }

    @PutMapping("/update/{id}")
    public PersonDTO UpdatePerson(@PathVariable Long id, @RequestBody PersonDTO person){
        return personService.UpdatePerson(id, person);
    }


    @DeleteMapping("/delete/{id}")
    public void DeletePerson(@PathVariable Long id){
        personService.DeletePerson(id);
    }
}
