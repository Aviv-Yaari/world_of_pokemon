package com.avivyaari.worldofpokemon.controller;


import com.avivyaari.worldofpokemon.dto.BagResponse;
import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<Trainer> getTrainers() throws CustomEntityNotFoundException {
        List<Trainer> trainers = trainerService.getAllTrainers();
        List<Trainer> responses = new ArrayList<>();
        trainers.forEach(trainer -> responses.add(new Trainer(trainer.getName(), trainer.getLevel(), trainer.getBag())));
        return responses;
    }

    @GetMapping("/{name}")
    public Trainer getTrainer(@PathVariable String name) throws CustomEntityNotFoundException {
        Trainer trainer = trainerService.getTrainer(name);
        return new Trainer(trainer.getName(), trainer.getLevel(), trainer.getBag());
    }

    @PatchMapping(value = "/{trainerName}/pokemon/{pokemonName}")
    public BagResponse catchPokemon(@PathVariable String trainerName, @PathVariable String pokemonName) throws CustomEntityNotFoundException, CustomEntityExistsException {
        List<Pokemon> bag = trainerService.catchPokemon(trainerName, pokemonName);
        return new BagResponse(bag);
    }
}
