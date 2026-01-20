package com.miage.diceGame.model;

import java.util.Random;
import java.util.Scanner;

public class Randomizer {

    private Random random;

    private static Randomizer randomizer;

    private Randomizer(){
        random = new Random();
    }

    public static Randomizer getInstance(){
        if(randomizer==null){
            randomizer=new Randomizer();
        }
        return randomizer;
    }

    public Random getRandom(){
        return random;
    }
}
