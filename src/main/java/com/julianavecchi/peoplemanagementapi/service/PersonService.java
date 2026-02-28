package com.julianavecchi.peoplemanagementapi.service;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.mapper.PersonMapper;
import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import com.julianavecchi.peoplemanagementapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO AddPerson(PersonDTO personDTO){
        PersonModel person = personMapper.map(personDTO);
        person = personRepository.save(person);
        return personMapper.map(person);
    }

    public List<PersonDTO> ShowAllPeople(){
        List<PersonModel> people = personRepository.findAll();
        return people.stream()
                    .map(personMapper::map)
                    .collect(Collectors.toList());
    }

    public PersonDTO ShowIdPerson(Long id){
        Optional<PersonModel> personId = personRepository.findById(id);
        return personId.map(personMapper::map).orElse(null);
    }


    public void DeletePerson(Long id){
        personRepository.deleteById(id);
    }

    public PersonDTO UpdatePerson(Long id, PersonDTO personDTO){
        Optional<PersonModel> personId = personRepository.findById(id);
        if(personId.isPresent()){
            PersonModel personUpdate = personMapper.map(personDTO);
            personUpdate.setId(id);
            PersonModel personSave = personRepository.save(personUpdate);
            return personMapper.map(personSave);
        }
        return null;
    }
}
