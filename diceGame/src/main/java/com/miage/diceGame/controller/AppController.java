package com.miage.diceGame.controller;

import com.miage.diceGame.model.Entree;
import com.miage.diceGame.model.Partie;
import com.miage.diceGame.model.Randomizer;
import com.miage.diceGame.service.EntreeService;
import com.miage.diceGame.service.Highscore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5000")
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
        Partie partie = new Partie();
        List<Entree> highscore = this.highscore.getHighscore();
        model.addAttribute("partie", partie);
        model.addAttribute("highscore", highscore);
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

    @PostMapping("/rollDice")
    @ResponseBody
    public Map<String, Integer> rollDice() {
        Randomizer random = Randomizer.getInstance();
        int val1 = random.getRandom().nextInt(6) + 1;
        int val2 = random.getRandom().nextInt(6) +1;
        Map<String, Integer> result = new HashMap<>();
        result.put("dice1", val1);
        result.put("dice2", val2);
        return result;
    }

    @PostMapping("/enregistrerPartie")
    @ResponseBody
    public ResponseEntity<?> enregistrerPartie(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        int score = (int) payload.get("score");
        entreeService.enregistrerScore(name, score);
        return ResponseEntity.ok().build();
    }
}
