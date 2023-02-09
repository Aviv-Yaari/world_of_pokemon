package com.avivyaari.worldofpokemon.controller;

import com.avivyaari.worldofpokemon.dto.BattleStatus;
import com.avivyaari.worldofpokemon.exception.BattleException;
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
    public String doBattle(@PathVariable String trainer1Name, @PathVariable String trainer2Name) throws BattleException {
        BattleStatus battleStatus = battleService.doBattle(trainer1Name, trainer2Name);
        if (battleStatus == BattleStatus.Draw) {
            return "Draw";
        }
        String winner = battleStatus == BattleStatus.Trainer1Won ? trainer1Name : trainer2Name;
        return winner + " won";
    }
}