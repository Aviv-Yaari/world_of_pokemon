package com.avivyaari.worldofpokemon.service;


import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;

import java.util.List;

public interface ITrainerService {
    List<Trainer> getTrainers() throws CustomEntityNotFoundException;
    Trainer getTrainer(Long id) throws CustomEntityNotFoundException;
    List<Pokemon> catchPokemon(String trainerName, String pokemonName) throws CustomEntityNotFoundException, CustomEntityExistsException;

}
