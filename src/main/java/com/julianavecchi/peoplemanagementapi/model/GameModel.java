package com.julianavecchi.peoplemanagementapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julianavecchi.peoplemanagementapi.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "game")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //OneToMany = Um jogo pode ser favorito de várias pessoas
    @OneToMany(mappedBy = "favoriteGame")
    @JsonIgnore
    private List<PersonModel> people;

}
