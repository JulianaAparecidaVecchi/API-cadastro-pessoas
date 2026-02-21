package com.julianavecchi.peoplemanagementapi.repository;

import com.julianavecchi.peoplemanagementapi.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {

}
