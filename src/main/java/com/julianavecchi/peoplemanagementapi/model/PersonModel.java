package com.julianavecchi.peoplemanagementapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "favorite_game_id")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "mother_name")
    private String motherName;

    //ManyToOne = uma pessoa posssui apenas um jogo favorito
    @ManyToOne
    @JoinColumn(name = "favorite_game_id")
    private GameModel favoriteGame;

}
