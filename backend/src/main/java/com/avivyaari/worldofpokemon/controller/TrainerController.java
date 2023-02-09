package com.avivyaari.worldofpokemon.controller;


import com.avivyaari.worldofpokemon.service.TrainerService;
import com.avivyaari.worldofpokemon.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/list")
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }
    
    @GetMapping("/{id}")
    public Trainer getTrainers(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }
    
}
