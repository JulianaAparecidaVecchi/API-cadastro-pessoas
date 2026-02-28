package com.julianavecchi.peoplemanagementapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julianavecchi.peoplemanagementapi.model.PersonModel;
import com.julianavecchi.peoplemanagementapi.model.enums.Genre;
import com.julianavecchi.peoplemanagementapi.model.enums.Platform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GameDTO {
        private Long id;
        private String name;
        private Platform platform;
        private Genre genre;
        private List<PersonModel> people;
}
