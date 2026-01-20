package com.miage.diceGame.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entree")
public class Entree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    @Column(name="date_entree")
    private Date date_entree;

}
