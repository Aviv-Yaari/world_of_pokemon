package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.exception.PokemonAlreadyInBagException;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService implements ITrainerService {
    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;
    
    @Autowired
    public TrainerService(TrainerRepository trainerRepository, PokemonRepository pokemonRepository) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Trainer> getTrainers() throws CustomEntityNotFoundException {
        List<Trainer> trainers = trainerRepository.findAll();
        if (trainers == null) {
            throw new CustomEntityNotFoundException("Trainers not found");
        }
        return trainers;
    }

    @Override
    public Trainer getTrainer(Long id) throws CustomEntityNotFoundException {
        Trainer trainer = trainerRepository.findAllById(id);
        if (trainer == null) {
            throw new CustomEntityNotFoundException("Trainer not found");
        }
        return trainer;
    }
    
    @Override
    public List<Pokemon> catchPokemon(String trainerName, String pokemonName) throws CustomEntityNotFoundException, PokemonAlreadyInBagException {
        Pokemon pokemon = pokemonRepository.findPokemonByNameIs(pokemonName);
        Trainer trainer = trainerRepository.findTrainerByNameIs(trainerName);
        if (pokemon == null) {
            throw new CustomEntityNotFoundException("Pokemon not found");
        }
        if (trainer == null) {
            throw new CustomEntityNotFoundException("Trainer not found");
        }
        trainer.addPokemon(pokemon);
        trainerRepository.save(trainer);
        return trainer.getBag();
    }
}
