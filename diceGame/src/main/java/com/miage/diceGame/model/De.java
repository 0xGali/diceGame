package com.miage.diceGame.model;

import java.util.Random;

public class De {

    private Integer value;
    private boolean lance = false;

    public De() {

    }

    public Integer getValue() throws Exception{
        if(!lance){
            throw new Exception("Le dé n'a pas été lancé");
        }
        return value;
    }

    public void lancer() throws Exception{
        if(lance){
            throw new Exception("Le dé a déjà été lancé");
        }
        value = Randomizer.getInstance().getRandom().nextInt(1,7);
        lance = true;
    }
}
