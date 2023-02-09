package com.avivyaari.worldofpokemon.controller;


import com.avivyaari.worldofpokemon.dto.TrainerResponse;
import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;
import com.avivyaari.worldofpokemon.service.TrainerService;
import com.avivyaari.worldofpokemon.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public List<TrainerResponse> getTrainers() throws CustomEntityNotFoundException {
        List<Trainer> trainers = trainerService.getTrainers();
        List<TrainerResponse> responses = new ArrayList<>();
        trainers.forEach(trainer -> responses.add(new TrainerResponse(trainer.getName(), trainer.getLevel(), trainer.getBag())));
        return responses;
    }
    
    @GetMapping("/{id}")
    public TrainerResponse getTrainer(@PathVariable Long id) throws CustomEntityNotFoundException {
        Trainer trainer = trainerService.getTrainer(id);
        return new TrainerResponse(trainer.getName(), trainer.getLevel(), trainer.getBag());
    }
    
    @PatchMapping(value = "/{trainerName}/catch/{pokemonName}")
    public ResponseEntity catchPokemon(@PathVariable String trainerName, @PathVariable String pokemonName) throws CustomEntityNotFoundException, CustomEntityExistsException {
        List<Pokemon> bag = trainerService.catchPokemon(trainerName, pokemonName);
        return ResponseEntity.ok(bag);
    }
}
