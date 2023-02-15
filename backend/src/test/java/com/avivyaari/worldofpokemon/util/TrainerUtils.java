package com.avivyaari.worldofpokemon.util;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerUtils {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    public Trainer createTrainer(String name, List<Pokemon> bag) {
        Trainer trainer = new Trainer(name, 22, bag);
        trainerRepository.save(trainer);
        return trainer;
    }

    public List<Pokemon> createBag(String prefix, PokemonType pokemonType) {
        List<Pokemon> bag = List.of(new Pokemon(prefix + "_1", pokemonType), new Pokemon(prefix + "_2", pokemonType), new Pokemon(prefix + "_3", pokemonType));
        pokemonRepository.saveAll(bag);
        return bag;
    }
}
