package com.julianavecchi.peoplemanagementapi.service;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.mapper.PersonMapper;
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
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonModel> ShowAllPeople(){
        return personRepository.findAll();
    }

    public PersonModel ShowIdPerson(Long id){
        Optional<PersonModel> personId = personRepository.findById(id);
        return personId.orElse(null);
    }

    public PersonDTO AddPerson(PersonDTO personDTO){
        PersonModel person = personMapper.map(personDTO);
        person = personRepository.save(person);
        return personMapper.map(person);
    }

    public void DeletePerson(Long id){
        personRepository.deleteById(id);
    }

    public PersonModel UpdatePerson(Long id, PersonModel personModel){
        if(personRepository.existsById(id)){
            personModel.setId(id);
            return personRepository.save(personModel);
        }
        return null;
    }
}
