package com.miage.diceGame.service;

import com.miage.diceGame.model.Entree;
import com.miage.diceGame.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;

    public List<Entree> getHighscore(){
        return entreeRepository.getHighscore();
    }

}
