package com.miage.diceGame.model;

import com.miage.diceGame.service.EntreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Highscore{

    private static Highscore highscore;

    public List<Entree> entrees;

    private Highscore(){
        entrees = new EntreeService().getHighscore();
    }

    public static Highscore getHighscore(){
        if(highscore == null){
            highscore = new Highscore();
        }
        else{
            highscore.entrees = new EntreeService().getHighscore();
        }
        return highscore;
    }
}
