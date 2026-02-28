package com.julianavecchi.peoplemanagementapi.dto;

import com.julianavecchi.peoplemanagementapi.model.GameModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime birthDate;
    private String motherName;
    private GameModel favoriteGame;


}
