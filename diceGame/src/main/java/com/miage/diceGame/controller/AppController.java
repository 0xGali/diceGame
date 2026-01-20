package com.miage.diceGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/game")
    public String game(){
        return "game";
    }

    @GetMapping("/rules")
    public String rules(){
        return "rules";
    }

    @GetMapping("/highscore")
    public String highscore(){
        return "highscore";
    }
}
