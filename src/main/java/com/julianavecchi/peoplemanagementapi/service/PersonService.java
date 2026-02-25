package com.julianavecchi.peoplemanagementapi.service;

import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import com.julianavecchi.peoplemanagementapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonModel> ShowAllPeople(){
        return personRepository.findAll();
    }

    public PersonModel ShowIdPerson(Long id){
        Optional<PersonModel> personId = personRepository.findById(id);
        return personId.orElse(null);
    }

    public PersonModel AddPerson(PersonModel person){
        return personRepository.save(person);
    }

    public void DeletePerson(Long id){
        personRepository.deleteById(id);
    }


}
