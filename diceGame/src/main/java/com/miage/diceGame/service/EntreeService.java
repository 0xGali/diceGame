package com.miage.diceGame.service;

import com.miage.diceGame.model.Entree;
import com.miage.diceGame.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;

    public Entree enregistrerScore(String name, int score){
        Entree entree = new Entree();
        entree.setName(name);
        entree.setScore(score);
        entree.setDate_entree(new Date());
        entreeRepository.save(entree);
        return entree;
    }

}
