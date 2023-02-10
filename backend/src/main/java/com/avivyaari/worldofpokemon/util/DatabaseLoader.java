package com.avivyaari.worldofpokemon.util;


import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
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
    public void run(String... args) {
        Pokemon pikachu = new Pokemon("Pikachu", PokemonType.Fire);
        Pokemon squirtle = new Pokemon("Squirtle", PokemonType.Grass);
        Pokemon mew = new Pokemon("Mew", PokemonType.Fire);

        Pokemon charizard = new Pokemon("Charizard", PokemonType.Fire);
        Pokemon snorlax = new Pokemon("Snorlax", PokemonType.Grass);
        Pokemon ditto = new Pokemon("Ditto", PokemonType.Water);

        LinkedList<Pokemon> pokemons = new LinkedList<>();
        pokemons.add(charizard);
        Trainer trainer = new Trainer("Aviv", 24, List.of(charizard, snorlax, ditto));
        Trainer trainer2 = new Trainer("Ash", 78, List.of(pikachu, squirtle, mew));
        Trainer trainer3 = new Trainer("Someone", 11, List.of(pikachu, snorlax, ditto));
        pokemonRepository.save(pikachu);
        pokemonRepository.save(squirtle);
        pokemonRepository.save(mew);
        pokemonRepository.save(charizard);
        pokemonRepository.save(snorlax);
        pokemonRepository.save(ditto);
        trainerRepository.save(trainer);
        trainerRepository.save(trainer2);
        trainerRepository.save(trainer3);
        
    }
}