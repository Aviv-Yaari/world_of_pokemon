package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findAllById(id);
    }
    
    @Override
    public List<Trainer> getTrainersForBattle(Set<String> names) {
        return trainerRepository.findAllByNameIn(names);
    }
    
}
