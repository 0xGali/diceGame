package com.miage.diceGame.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "entree")
public class Entree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private int id;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @Column(name = "score")
    private int score;

    @Getter
    @Column(name="date_entree")
    private Date date_entree;

    public String getDateFormatee(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date_entree);
    }

}
