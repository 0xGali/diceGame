package com.miage.diceGame.model;

import java.util.Random;

public class Partie {

    private String name;

    private De[][] des = new De[10][2];

    private Integer tour = 0;

    public Partie(){
        for(int i = 0;i < 10; i++){
            des[i][0] = new De();
            des[i][1] = new De();
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void jouer() throws Exception{
        if(tour >= 10){
            throw new Exception("tout les dés ont été lancés, la partie est finie");
        }
        des[tour][0].lancer();
        des[tour][1].lancer();
        tour++;
    }

    public Integer calculScore(){
        try {
            int score = 0;
            for (int i = 0; i < tour; i++) {
                if (des[i][0].getValue() + des[i][1].getValue() == 7){
                    score+=10;
                }
            }
            return score;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("La partie est corrompue : score nul");
            return 0;
        }
    }

    public De[][] getDes(){
       return des;
    }
}
