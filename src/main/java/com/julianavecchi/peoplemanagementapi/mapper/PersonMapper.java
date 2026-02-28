package com.julianavecchi.peoplemanagementapi.mapper;

import com.julianavecchi.peoplemanagementapi.dto.PersonDTO;
import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonModel map(PersonDTO personDTO){
        PersonModel personModel = new PersonModel();
        personModel.setName(personDTO.getName());
        personModel.setEmail(personDTO.getEmail());
        personModel.setBirthDate(personDTO.getBirthDate());
        personModel.setMotherName(personDTO.getMotherName());
        personModel.setFavoriteGame(personDTO.getFavoriteGame());

        return personModel;
    }

    public PersonDTO map(PersonModel personModel){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personModel.getId());
        personDTO.setName(personModel.getName());
        personDTO.setEmail(personModel.getEmail());
        personDTO.setBirthDate(personModel.getBirthDate());
        personDTO.setMotherName(personModel.getMotherName());
        personDTO.setFavoriteGame(personModel.getFavoriteGame());

        return personDTO;
    }
}
