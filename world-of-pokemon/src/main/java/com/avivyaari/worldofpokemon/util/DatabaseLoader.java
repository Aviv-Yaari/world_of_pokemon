package com.avivyaari.worldofpokemon.util;


import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;

    public DatabaseLoader(PokemonRepository pokemonRepository, TrainerRepository trainerRepository) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Pokemon pikachu = new Pokemon("Pikachu", PokemonType.Fire);
        Pokemon charizard = new Pokemon("Charizard", PokemonType.Fire);
        Pokemon squirtle = new Pokemon("Squirtle", PokemonType.Grass);
        
        Trainer trainer = new Trainer("Aviv", 24, List.of(pikachu, charizard));
        pokemonRepository.save(pikachu);
        pokemonRepository.save(charizard);
        pokemonRepository.save(squirtle);
        trainerRepository.save(trainer);
        
    }
}