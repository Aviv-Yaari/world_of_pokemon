package com.avivyaari.worldofpokemon.controller;

import com.avivyaari.worldofpokemon.dto.BattleResult;
import com.avivyaari.worldofpokemon.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battle")
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }


    @GetMapping("/{trainer1Name}/{trainer2Name}")
    public BattleResult doBattle(@PathVariable String trainer1Name, @PathVariable String trainer2Name) {
        return battleService.doBattle(trainer1Name, trainer2Name);
    }
}