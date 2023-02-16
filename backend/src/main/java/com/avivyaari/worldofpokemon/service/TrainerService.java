package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService implements ITrainerService {
    private final TrainerRepository trainerRepository;
    private final PokemonService pokemonService;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository, PokemonService pokemonService) {
        this.trainerRepository = trainerRepository;
        this.pokemonService = pokemonService;
    }

    @Override
    public List<Trainer> getAllTrainers() throws CustomEntityNotFoundException {
        List<Trainer> trainers = trainerRepository.findAll();
        if (trainers.isEmpty()) {
            throw new CustomEntityNotFoundException("No trainers found");
        }
        return trainers;
    }

    @Override
    public Trainer getTrainer(String name) throws CustomEntityNotFoundException {
        Trainer trainer = trainerRepository.findTrainerByNameIs(name)
                .orElseThrow(() -> new CustomEntityNotFoundException("Trainer not found"));
        return trainer;
    }
    
    @Override
    public List<Pokemon> catchPokemon(String trainerName, String pokemonName) throws CustomEntityNotFoundException, CustomEntityExistsException {
        Pokemon pokemon = pokemonService.getPokemon(pokemonName);
        Trainer trainer = getTrainer(trainerName);
        if (trainer == null) {
            throw new CustomEntityNotFoundException("Trainer not found");
        }
        trainer.addPokemon(pokemon);
        trainerRepository.save(trainer);
        return trainer.getBag();
    }
}
