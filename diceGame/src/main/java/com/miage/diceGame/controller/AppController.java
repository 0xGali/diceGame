package com.miage.diceGame.controller;

import com.miage.diceGame.model.Entree;
import com.miage.diceGame.service.EntreeService;
import com.miage.diceGame.service.Highscore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    Highscore highscore;

    @Autowired
    EntreeService entreeService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/game")
    public String game(Model model){
        return "game";
    }

    @GetMapping("/rules")
    public String rules(){
        return "rules";
    }

    @GetMapping("/highscore")
    public String highscore(Model model){
        List<Entree> highscore = this.highscore.getHighscore();
        model.addAttribute("highscore", highscore);
        return "highscore";
    }
}
