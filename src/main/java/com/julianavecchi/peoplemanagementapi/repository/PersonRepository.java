package com.julianavecchi.peoplemanagementapi.repository;

import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
